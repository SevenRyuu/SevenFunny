package com.seven.roast.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author ：SevenRyuu
 * date   ：2019/9/6 5:35 PM
 * email  ：sevenryuu77@gmail.com
 */
@Document(collection = "sf_roast")
public class Roast {

    private String _id;

    private String nickname;

    private String content;

    private Long visit_cnt;

    private Long share_cnt;

    private Long thumbsup_cnt;

    private String state;

    private String reg_id;

    private Date reg_dt;

    private String upd_id;

    private Date upd_dt;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getVisit_cnt() {
        return visit_cnt;
    }

    public void setVisit_cnt(Long visit_cnt) {
        this.visit_cnt = visit_cnt;
    }

    public Long getShare_cnt() {
        return share_cnt;
    }

    public void setShare_cnt(Long share_cnt) {
        this.share_cnt = share_cnt;
    }

    public Long getThumbsup_cnt() {
        return thumbsup_cnt;
    }

    public void setThumbsup_cnt(Long thumbsup_cnt) {
        this.thumbsup_cnt = thumbsup_cnt;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
