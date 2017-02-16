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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getSecretId() {
        return secretId;
    }

    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getEmailHostName() {
        return emailHostName;
    }

    public void setEmailHostName(String emailHostName) {
        this.emailHostName = emailHostName;
    }

    public int getEmailPort() {
        return emailPort;
    }

    public void setEmailPort(int emailPort) {
        this.emailPort = emailPort;
    }

    public String getEmailUserName() {
        return emailUserName;
    }

    public void setEmailUserName(String emailUserName) {
        this.emailUserName = emailUserName;
    }

    public String getEmailPassword() {
        return emailPassword;
    }

    public void setEmailPassword(String emailPassword) {
        this.emailPassword = emailPassword;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public List<String> getMobiles() {
        return mobiles;
    }

    public void setMobiles(List<String> mobiles) {
        this.mobiles = mobiles;
    }
}
