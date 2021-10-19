package com.lin.pojo;

import java.util.Date;

public class Email {
    private Integer id;
    private Integer fromuid;
    private Integer touid;
    private String title;
    private String content;
    private Date sendtime;
    private Integer state;

    public Email() {

    }

    public Email(Integer id, Integer fromuid, Integer touid, String title, String content, Date sendtime, Integer state) {
        this.id = id;
        this.fromuid = fromuid;
        this.touid = touid;
        this.title = title;
        this.content = content;
        this.sendtime = sendtime;
        this.state = state;
    }


    public Email(Integer fromuid, Integer touid, String title, String content, Date sendtime, Integer state) {
        this.fromuid = fromuid;
        this.touid = touid;
        this.title = title;
        this.content = content;
        this.sendtime = sendtime;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromuid() {
        return fromuid;
    }

    public void setFromuid(Integer fromuid) {
        this.fromuid = fromuid;
    }

    public Integer getTouid() {
        return touid;
    }

    public void setTouid(Integer touid) {
        this.touid = touid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", fromuid=" + fromuid +
                ", touid=" + touid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", sendtime=" + sendtime +
                ", state=" + state +
                '}';
    }
}
