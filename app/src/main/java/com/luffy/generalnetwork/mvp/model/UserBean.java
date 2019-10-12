package com.luffy.generalnetwork.mvp.model;

/**
 * Created by lvlufei on 2018/11/3
 *
 * @desc 用户-实体类
 */
public class UserBean {
    private String avatar;
    private String create_time;
    private String mobile;
    private String sso_id;
    private String uname;
    private String user_id;

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCreate_time() {
        return this.create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSso_id() {
        return this.sso_id;
    }

    public void setSso_id(String sso_id) {
        this.sso_id = sso_id;
    }

    public String getUname() {
        return this.uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
