package com.luffy.generalnetwork.mvp.presenter;


import com.luffy.apilib.retrofit.BaseLayerApiObserver;
import com.luffy.generalnetwork.api.retrofit.ApiClient;
import com.luffy.generalnetwork.mvp.contract.LoginContract;
import com.luffy.generalnetwork.mvp.model.LoginBean;
import com.luffy.mvplib.BaseLayerPresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lvlufei on 2018/11/3
 *
 * @desc 登录-主持类
 */
public class LoginPresenter extends BaseLayerPresenter<LoginContract.LoginView> implements LoginContract.LoginPresenter {

    public LoginPresenter(LoginContract.LoginView view) {
        super(view);
    }

    @Override
    public void requestUserLogin(String mobile, String password) {
        ApiClient.getInstance().getApiService()
                .getUserLogin(mobile, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseLayerApiObserver<LoginBean>() {

                    @Override
                    public void onObserverError(Throwable e) {
                        view.onObserverError(e, LoginPresenter.this);
                    }


                    @Override
                    public void onObserverNext(LoginBean loginBean) {
                        view.showLogin(loginBean);
                    }

                });
    }

    @Override
    public void requestSimulateData() {

    }
}
