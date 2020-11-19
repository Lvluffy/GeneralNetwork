package com.luffy.generalnetwork.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.luffy.apilib.httpClient.HttpClient;
import com.luffy.apilib.retrofit.BaseLayerApiObserver;
import com.luffy.generalnetwork.R;
import com.luffy.generalnetwork.api.retrofit.ApiClient;
import com.luffy.generalnetwork.mvp.contract.LoginContract;
import com.luffy.generalnetwork.mvp.model.LoginBean;
import com.luffy.generalnetwork.mvp.presenter.LoginPresenter;
import com.luffy.mvplib.BaseLayerPresenter;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.Response;

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


    @OnClick({R.id.btn_login_1, R.id.btn_login_2, R.id.btn_login_3, R.id.btn_login_4})
    public void onViewClicked(View view) {
        txtTitle.setText("");
        switch (view.getId()) {
            case R.id.btn_login_1:
                presenter.requestUserLogin("18301639782", "123456");
                break;
            case R.id.btn_login_2:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        bindData(getData("18301639782", "123456"));
                    }
                }).start();
                break;
            case R.id.btn_login_3:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        bindData(getData1("18301639782", "123456"));
                    }
                }).start();
                break;
            case R.id.btn_login_4:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        bindData(getData2("18301639782", "123456"));
                    }
                }).start();
                break;
        }
    }

    private void bindData(LoginBean loginBean) {
        if (loginBean == null) {
            return;
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                txtTitle.setText("UserId == " + loginBean.getUser().getUser_id());
            }
        });
    }

    /**
     * 异步请求同步返回（OkHttp+RxJava）
     *
     * @param mobile
     * @param password
     * @return
     */
    private LoginBean getData(String mobile, String password) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        final LoginBean[] data = new LoginBean[1];
        ApiClient.getInstance()
                .getApiService()
                .getUserLogin(mobile, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseLayerApiObserver<LoginBean>() {
            @Override
            public void onObserverError(Throwable e) {
            }

            @Override
            public void onObserverNext(LoginBean loginBean) {
                data[0] = loginBean;
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return data[0];
    }


    /**
     * 同步请求（OkHttp）
     *
     * @param mobile
     * @param password
     * @return
     */
    private LoginBean getData1(String mobile, String password) {
        LoginBean data = null;
        Request request = new Request.Builder()
                .url("http://open.51zhishang.com/v2/user/login")
                .post(new FormBody.Builder()
                        .add("mobile", mobile)
                        .add("password", password)
                        .build())
                .build();
        try {
            Response response = HttpClient.getInstance(ApiClient.getInstance().getOkHttpClient()).execute(request);
            String jstr = response.body().string();
            Gson gson = new Gson();
            data = gson.fromJson(jstr, LoginBean.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * 异步请求同步返回（OkHttp）
     *
     * @param mobile
     * @param password
     * @return
     */
    private LoginBean getData2(String mobile, String password) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        final LoginBean[] data = new LoginBean[1];
        Request request = new Request.Builder()
                .url("http://open.51zhishang.com/v2/user/login")
                .post(new FormBody.Builder()
                        .add("mobile", mobile)
                        .add("password", password)
                        .build())
                .build();

        HttpClient.getInstance(ApiClient.getInstance().getOkHttpClient()).enqueue(request, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                countDownLatch.countDown();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String jstr = response.body().string();
                Gson gson = new Gson();
                data[0] = gson.fromJson(jstr, LoginBean.class);
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return data[0];
    }

}
