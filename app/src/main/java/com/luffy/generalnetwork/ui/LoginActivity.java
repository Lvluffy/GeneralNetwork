package com.luffy.generalnetwork.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.luffy.generalnetwork.R;
import com.luffy.generalnetwork.mvp.contract.LoginContract;
import com.luffy.generalnetwork.mvp.model.LoginBean;
import com.luffy.generalnetwork.mvp.presenter.LoginPresenter;
import com.luffy.mvplib.BaseLayerPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lvlufei on 2018/11/3
 *
 * @desc 登录
 */
public class LoginActivity extends AppCompatActivity implements LoginContract.LoginView {

    LoginPresenter presenter;

    @BindView(R.id.txt_title)
    TextView txtTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        presenter = new LoginPresenter(this);
    }

    @Override
    public void showLogin(LoginBean loginBean) {
        if (loginBean.getStatus() == 1) {
            txtTitle.setText("UserId == " + loginBean.getUser().getUser_id());
        } else {
            txtTitle.setText("loginBean == null");
        }
    }

    @Override
    public void onLoading(boolean isShow, BaseLayerPresenter cls) {

    }

    @Override
    public void onObserverError(Throwable e, BaseLayerPresenter cls) {
        txtTitle.setText(e.toString());
    }

    @Override
    public void onNetworkError(BaseLayerPresenter cls) {

    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        presenter.requestUserLogin("18301639782", "123456");
    }
}
