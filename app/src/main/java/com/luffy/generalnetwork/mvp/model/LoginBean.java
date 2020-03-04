package com.luffy.generalnetwork.mvp.model;


import com.luffy.mvplib.BaseLayerModel;

/**
 * Created by lvlufei on 2018/11/3
 *
 * @desc 登录-实体类
 */
public class LoginBean extends BaseLayerModel {

    private int status;

    private String msg;

    private UserBean user;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }
}
