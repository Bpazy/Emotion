package com.github.bpazy.emotion;

import com.github.bpazy.emotion.exception.ConvertEmotionException;
import com.github.bpazy.emotion.vo.Emotion;
import com.github.bpazy.emotion.vo.EmotionConfig;
import com.github.bpazy.emotion.vo.WeiboItem;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.qcloud.Module.Wenzhi;
import com.qcloud.QcloudApiModuleCenter;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import net.sf.cglib.beans.BeanCopier;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * Created by Ziyuan
 * on 2017/2/13
 */
public class Text2Emotion {

    private BeanCopier copier = BeanCopier.create(EmotionConfig.class, EmotionConfig.class, false);
    private final long PERIOD = 60 * 1000;

    private Logger logger = LoggerFactory.getLogger(Text2Emotion.class);
    private Gson gson = new Gson();
    private EmotionConfig config;

    private Emotion analysis(String content) throws ConvertEmotionException {
        TreeMap<String, Object> wzConfig = new TreeMap<>();
        wzConfig.put("SecretId", config.getSecretId());
        wzConfig.put("SecretKey", config.getSecretKey());

        wzConfig.put("RequestMethod", "GET");
        wzConfig.put("DefaultRegion", "gz");

        QcloudApiModuleCenter module = new QcloudApiModuleCenter(new Wenzhi(), wzConfig);

        TreeMap<String, Object> params = new TreeMap<>();
        params.put("content", content);
        params.put("type", "4");

        String result;
        try {
            result = module.call("TextSentiment", params);
        } catch (Exception e) {
            throw new ConvertEmotionException();
        }
        return gson.fromJson(result, Emotion.class);
    }

    public void run(EmotionConfig config) {
        startModifyConfigPeriod();
        this.config = config;
        String url = "https://api.prprpr.me/weibo/rss/" + config.getUid();
        try {
            SyndFeed feed = new SyndFeedInput().build(new XmlReader(new URL(url)));
            List<SyndEntry> entries = feed.getEntries();
            List<WeiboItem> items = Lists.newArrayList();
            entries.forEach(syndEntry -> {
                WeiboItem weiboItem = createWeiboItem(syndEntry);
                items.add(weiboItem);
            });
            items.forEach(item -> {
                handleText(item.getText());
            });
        } catch (FeedException | IOException e) {
            logger.error("创建URL错误", e);
        }
    }

    private WeiboItem createWeiboItem(SyndEntry entry) {
        String value = entry.getDescription().getValue();
        Document parse = Jsoup.parseBodyFragment(value);
        String text = parse.text();
        Date publishedDate = entry.getPublishedDate();
        WeiboItem item = new WeiboItem();
        item.setText(text);
        item.setPublishedDate(publishedDate);
        return item;
    }

    private void startModifyConfigPeriod() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                EmotionConfig emotionConfig = Helper.loadConfig();
                copier.copy(emotionConfig, config, null);
            }
        }, PERIOD, PERIOD);
    }

    private void handleText(String text) {
        if (text.contains("转发")) {
            return;
        }
        try {
            Emotion emotion = analysis(text);
            logger.info("{}", emotion);
            boolean negative = checkNegativeEmotion(emotion);
            if (negative) {
                String msg = String.format("检测到消极情绪微博: (乐观%.0f%% 消极%.0f%%)\n%s",
                        emotion.getPositive() * 100,
                        emotion.getNegative() * 100,
                        text);
                Helper.sendEmail(config, msg);
            }
        } catch (ConvertEmotionException e) {
            logger.error("腾讯文智错误，分析情绪失败", e);
        }
    }

    private boolean checkNegativeEmotion(Emotion emotion) {
        double positive = emotion.getPositive();
        double negative = emotion.getNegative();
        return positive < negative;
    }
}
