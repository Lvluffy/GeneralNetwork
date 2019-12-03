package com.luffy.generalnetworklib.mvp;

/**
 * Created by lvlufei on 2018/11/3
 *
 * @desc MVP模式开发之View
 */
public interface BaseLayerView {

    /**
     * 加载Loading
     *
     * @param isShow
     * @param cls
     */
    void onLoading(boolean isShow, BaseLayerPresenter cls);

    /**
     * 请求异常
     *
     * @param e
     * @param cls
     */
    void onObserverError(Throwable e, BaseLayerPresenter cls);

    /**
     * 网络异常
     *
     * @param cls
     */
    void onNetworkError(BaseLayerPresenter cls);
}
