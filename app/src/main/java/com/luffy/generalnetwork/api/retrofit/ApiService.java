package com.luffy.generalnetwork.api.retrofit;


import com.luffy.generalnetwork.helper.ConstantsHelper;
import com.luffy.generalnetwork.mvp.model.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by lvlufei on 2018/11/3
 *
 * @desc 网络（Retrofit）服务端
 */
public interface ApiService {

    /**
     * 用户登录
     *
     * @param mobile
     * @param password
     * @return
     */
    @FormUrlEncoded
    @POST(ConstantsHelper.Api.LOGIN)
    Observable<LoginBean> getUserLogin(@Field("mobile") String mobile, @Field("password") String password);
}
