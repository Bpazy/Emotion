package com.github.bpazy.emotion;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Created by Ziyuan
 * on 2017/2/15
 */
public class Helper {

    private static Logger logger = LoggerFactory.getLogger(Helper.class);
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static EmotionConfig loadConfig() {
        try {
            return gson.fromJson(new FileReader("emotion.json"), EmotionConfig.class);
        } catch (FileNotFoundException e) {
            logger.error("文件emotion.json不存在", e);
            File file = new File("emotion.json");
            try {
                boolean newFile = file.createNewFile();
                if (!newFile) {
                    throw new IOException();
                }
                FileOutputStream outputStream = new FileOutputStream(file);
                outputStream.write(gson.toJson(defaultEmotionConfig()).getBytes());
                logger.info("创建配置文件成功, {}", file.getAbsolutePath());
            } catch (IOException e1) {
                logger.error("创建配置文件失败", e1);
            }
            System.exit(0);
        }
        throw new Error("Logic ERROR");
    }

    private static EmotionConfig defaultEmotionConfig() {
        EmotionConfig config = new EmotionConfig();
        config.setEmails(Lists.newArrayList("example@example.com"));
        config.setMobiles(Lists.newArrayList("12345678910"));
        config.setUid("0000000000");
        config.setSecretId("Your secretId");
        config.setSecretKey("Your secretKey");
        config.setEmailHostName("smtp.163.com");
        config.setEmailPort(465);
        config.setEmailUserName("YourUserName");
        config.setEmailPassword("YourPassword");
        return config;
    }

    public static void sendEmail(EmotionConfig config, String msg) {
        try {
            Email email = new SimpleEmail();
            email.setHostName(config.getEmailHostName());
            email.setSmtpPort(config.getEmailPort());
            email.setAuthenticator(new DefaultAuthenticator(config.getEmailUserName(), config.getEmailPassword()));
            email.setSSLOnConnect(true);
            email.setFrom(config.getEmailUserName());
            email.setSubject("EmotionMail");
            email.setMsg(msg);
            for (String mail : config.getEmails()) {
                email.addTo(mail);
            }
            email.send();
            logger.info("Email send to:{} - {}", config.getEmails(), msg);
        } catch (EmailException e) {
            logger.error("邮箱地址填写错误或发送失败", e);
        }
    }
}
