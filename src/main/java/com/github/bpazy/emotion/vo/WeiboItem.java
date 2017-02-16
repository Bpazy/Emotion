package com.github.bpazy.emotion.vo;

import java.util.Date;

/**
 * Created by Ziyuan
 * on 2017/2/16
 */
public class WeiboItem {
    private Date publishedDate;
    private String text;

    @Override
    public String toString() {
        return "WeiboItem{" +
                "publishedDate=" + publishedDate +
                ", text='" + text + '\'' +
                '}';
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
