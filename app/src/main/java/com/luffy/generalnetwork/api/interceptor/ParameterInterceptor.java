package com.luffy.generalnetwork.api.interceptor;

import com.luffy.apilib.interceptor.parameter.BaseLayerParameterOfBodyInterceptor;
import com.luffy.generalnetwork.api.commonParameters.ParametersHelper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.FormBody;

/**
 * Created by lvlufei on 2018/11/3
 *
 * @desc 参数拦截器
 */
public class ParameterInterceptor extends BaseLayerParameterOfBodyInterceptor {
    @Override
    public void addPublicBody(FormBody.Builder formBodyBuilder) throws IOException {
        HashMap<String, String> parameters = ParametersHelper.getInstance().getParameters();
        for (Map.Entry entry : parameters.entrySet()) {
            formBodyBuilder.add(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
        }
        FormBody newFormBody = formBodyBuilder.build();
        formBodyBuilder.add("sign", ParametersHelper.getInstance().getSign(newFormBody));
    }
}
