package com.luffy.generalnetwork.mvp.contract;


import com.luffy.generalnetwork.mvp.model.LoginBean;
import com.luffy.mvplib.BaseLayerView;

/**
 * Created by lvlufei on 2018/11/3
 *
 * @desc 登录-契约类
 */
public interface LoginContract {

    interface LoginView extends BaseLayerView {

        void showLogin(LoginBean loginBean);

    }

    interface LoginPresenter {
        /*请求~用户登录*/
        void requestUserLogin(String mobile, String password);
    }
}
