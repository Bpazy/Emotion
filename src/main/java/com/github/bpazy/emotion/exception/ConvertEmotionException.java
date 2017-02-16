package com.github.bpazy.emotion.exception;

import com.github.bpazy.emotion.vo.Emotion;

/**
 * Created by Ziyuan
 * on 2017/2/13
 */
public class ConvertEmotionException extends Exception {

    public ConvertEmotionException() {
    }

    public ConvertEmotionException(Emotion emotion) {
        super(emotion.toString());
    }

    public ConvertEmotionException(Exception e) {
        super(e);
    }
}
