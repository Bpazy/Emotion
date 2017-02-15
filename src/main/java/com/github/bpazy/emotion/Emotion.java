package com.github.bpazy.emotion;

/**
 * Created by Ziyuan
 * on 2017/2/13
 */
public class Emotion {

    private String codeDesc;
    private double negative;
    private int code;
    private double positive;
    private String message;

    @Override
    public String toString() {
        return "Emotion{" +
                "codeDesc='" + codeDesc + '\'' +
                ", negative=" + negative +
                ", code=" + code +
                ", positive=" + positive +
                ", message='" + message + '\'' +
                '}';
    }

    public String getCodeDesc() {
        return codeDesc;
    }

    public void setCodeDesc(String codeDesc) {
        this.codeDesc = codeDesc;
    }

    public double getNegative() {
        return negative;
    }

    public void setNegative(double negative) {
        this.negative = negative;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getPositive() {
        return positive;
    }

    public void setPositive(double positive) {
        this.positive = positive;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
