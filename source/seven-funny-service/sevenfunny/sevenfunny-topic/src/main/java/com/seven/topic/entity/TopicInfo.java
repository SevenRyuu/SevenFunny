package com.seven.topic.entity;

import java.util.Date;

public class TopicInfo {

    private String id;

    private String title;

    private String content;

    private String label;

    private String status;

    private Long visit_cnt;

    private Long reply_cnt;

    private String reg_id;

    private Date reg_dt;

    private String upd_id;

    private Date upd_dt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getVisit_cnt() {
        return visit_cnt;
    }

    public void setVisit_cnt(Long visit_cnt) {
        this.visit_cnt = visit_cnt;
    }

    public Long getReply_cnt() {
        return reply_cnt;
    }

    public void setReply_cnt(Long reply_cnt) {
        this.reply_cnt = reply_cnt;
    }

    public String getReg_id() {
        return reg_id;
    }

    public void setReg_id(String reg_id) {
        this.reg_id = reg_id;
    }

    public Date getReg_dt() {
        return reg_dt;
    }

    public void setReg_dt(Date reg_dt) {
        this.reg_dt = reg_dt;
    }

    public String getUpd_id() {
        return upd_id;
    }

    public void setUpd_id(String upd_id) {
        this.upd_id = upd_id;
    }

    public Date getUpd_dt() {
        return upd_dt;
    }

    public void setUpd_dt(Date upd_dt) {
        this.upd_dt = upd_dt;
    }
}
