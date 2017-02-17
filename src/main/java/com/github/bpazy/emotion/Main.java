package com.github.bpazy.emotion;

import com.github.bpazy.emotion.vo.EmotionConfig;

/**
 * Created by Ziyuan
 * on 2017/2/13
 */
public class Main {
    private static EmotionConfig config = Helper.loadConfig();

    public static void main(String[] args) {
        Text2Emotion emotion = new Text2Emotion();
        emotion.run(config);
    }
}
