package com.luffy.generalnetwork.api.interceptor;

import com.luffy.apilib.interceptor.parameter.BaseLayerParameterOfBodyInterceptor;
import com.luffy.generalnetwork.helper.ConstantsHelper;
import com.luffy.generalnetwork.utils.MD5Utils;
import com.luffy.generalnetwork.utils.RandomUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
        HashMap<String, String> parameters = getParameters();
        for (Map.Entry entry : parameters.entrySet()) {
            formBodyBuilder.add(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
        }
        FormBody newFormBody = formBodyBuilder.build();
        formBodyBuilder.add("sign", getSign(newFormBody));
    }

    public HashMap<String, String> getParameters() {
        HashMap<String, String> paremeters = new HashMap<>();
        paremeters.put("app_id", ConstantsHelper.ServerSecret.APP_ID);
        paremeters.put("device_token", "d43e6f76ff5f414c82bf6ac41464c98a");
        paremeters.put("nonce_str", RandomUtils.getInstance().getRandomStringByLength(32));
        paremeters.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        paremeters.put("user_id", "0");
        return paremeters;
    }

    public String getSign(FormBody formBody) {
        ArrayList<String> list = new ArrayList<>();
        if (formBody != null) {
            for (int i = 0; i < formBody.size(); i++) {
                String name = formBody.name(i);
                String value = formBody.value(i);
                list.add(name + "=" + value + "&");
            }
        }
        int size = list.size();
        String[] arrayToSort = list.toArray(new String[size]);
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(arrayToSort[i]);
        }
        String result = sb.toString();
        result += "app_secret=" + ConstantsHelper.ServerSecret.APP_SECRET;
        result = MD5Utils.getInstance().md5(result).toUpperCase();
        return result;
    }
}
