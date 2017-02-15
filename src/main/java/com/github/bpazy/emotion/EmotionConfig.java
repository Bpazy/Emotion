package com.github.bpazy.emotion;

import java.util.List;

/**
 * Created by Ziyuan
 * on 2017/2/15
 */
public class EmotionConfig {
    private String uid;
    private String secretId;
    private String secretKey;
    private String emailHostName;
    private int emailPort;
    private String emailUserName;
    private String emailPassword;
    private List<String> emails;
    private List<String> mobiles;

    @Override
    public String toString() {
        return "EmotionConfig{" +
                "uid='" + uid + '\'' +
                ", secretId='" + secretId + '\'' +
                ", secretKey='" + secretKey + '\'' +
                ", emailHostName='" + emailHostName + '\'' +
                ", emailPort=" + emailPort +
                ", emailUserName='" + emailUserName + '\'' +
                ", emailPassword='" + emailPassword + '\'' +
                ", emails=" + emails +
                ", mobiles=" + mobiles +
                '}';
    }

    public String getEmailHostName() {
        return emailHostName;
    }

    public EmotionConfig setEmailHostName(String emailHostName) {
        this.emailHostName = emailHostName;
        return this;
    }

    public int getEmailPort() {
        return emailPort;
    }

    public EmotionConfig setEmailPort(int emailPort) {
        this.emailPort = emailPort;
        return this;
    }

    public String getEmailUserName() {
        return emailUserName;
    }

    public EmotionConfig setEmailUserName(String emailUserName) {
        this.emailUserName = emailUserName;
        return this;
    }

    public String getEmailPassword() {
        return emailPassword;
    }

    public EmotionConfig setEmailPassword(String emailPassword) {
        this.emailPassword = emailPassword;
        return this;
    }

    public String getSecretId() {
        return secretId;
    }

    public EmotionConfig setSecretId(String secretId) {
        this.secretId = secretId;
        return this;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public EmotionConfig setSecretKey(String secretKey) {
        this.secretKey = secretKey;
        return this;
    }

    public String getUid() {
        return uid;
    }

    public EmotionConfig setUid(String uid) {
        this.uid = uid;
        return this;
    }

    public List<String> getEmails() {
        return emails;
    }

    public EmotionConfig setEmails(List<String> emails) {
        this.emails = emails;
        return this;
    }

    public List<String> getMobiles() {
        return mobiles;
    }

    public EmotionConfig setMobiles(List<String> mobiles) {
        this.mobiles = mobiles;
        return this;
    }
}
