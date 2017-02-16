package com;

import com.github.bpazy.emotion.EmotionConfig;
import com.github.bpazy.emotion.Helper;
import com.github.bpazy.emotion.Text2Emotion;

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
