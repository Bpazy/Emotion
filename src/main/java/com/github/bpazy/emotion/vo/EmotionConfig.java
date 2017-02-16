package com.github.bpazy.emotion.vo;

import java.util.List;
import java.util.Objects;

/**
 * Created by Ziyuan
 * on 2017/2/15
 */
public class EmotionConfig {
    private String uid;
    private List<String> filters;
    private int threshold;
    private String secretId;
    private String secretKey;
    private String emailHostName;
    private int emailPort;
    private String emailUserName;
    private String emailPassword;
    private List<String> emails;
    private List<String> mobiles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmotionConfig that = (EmotionConfig) o;
        return threshold == that.threshold &&
                emailPort == that.emailPort &&
                Objects.equals(uid, that.uid) &&
                Objects.equals(filters, that.filters) &&
                Objects.equals(secretId, that.secretId) &&
                Objects.equals(secretKey, that.secretKey) &&
                Objects.equals(emailHostName, that.emailHostName) &&
                Objects.equals(emailUserName, that.emailUserName) &&
                Objects.equals(emailPassword, that.emailPassword) &&
                Objects.equals(emails, that.emails) &&
                Objects.equals(mobiles, that.mobiles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, filters, threshold, secretId, secretKey, emailHostName, emailPort, emailUserName, emailPassword, emails, mobiles);
    }

    @Override
    public String toString() {
        return "EmotionConfig{" +
                "uid='" + uid + '\'' +
                ", filters=" + filters +
                ", threshold=" + threshold +
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

    public List<String> getFilters() {
        return filters;
    }

    public EmotionConfig setFilters(List<String> filters) {
        this.filters = filters;
        return this;
    }

    public int getThreshold() {
        return threshold;
    }

    public EmotionConfig setThreshold(int threshold) {
        this.threshold = threshold;
        return this;
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
