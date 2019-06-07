package com.seven.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ：SevenRyuu
 * date   ：2019/5/27 9:45 PM
 * email  ：sevenryuu77@gmail.com
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class UserInfo implements Serializable {

    private String id;

    private String mobile;

    private String password;

    private String nickname;

    private String gender;

    private Date birthday;

    private String email;

    private String avatar;

    private String intro;

    @JsonIgnore
    private Date reg_dt;

    @JsonIgnore
    private Date upd_dt;

    private Date last_dt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Date getReg_dt() {
        return reg_dt;
    }

    public void setReg_dt(Date reg_dt) {
        this.reg_dt = reg_dt;
    }

    public Date getUpd_dt() {
        return upd_dt;
    }

    public void setUpd_dt(Date upd_dt) {
        this.upd_dt = upd_dt;
    }

    public Date getLast_dt() {
        return last_dt;
    }

    public void setLast_dt(Date last_dt) {
        this.last_dt = last_dt;
    }
}
