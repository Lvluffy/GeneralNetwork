package com.luffy.mvplib;

/**
 * Created by lvlufei on 2018/11/3
 *
 * @desc MVP模式开发之View
 */
public interface BaseLayerView {

    /**
     * 加载Loading
     *
     * @param isShow 是否显示
     * @param cls    基础Presenter
     */
    void onLoading(boolean isShow, BaseLayerPresenter cls);

    /**
     * 请求异常
     *
     * @param e   Throwable
     * @param cls 基础Presenter
     */
    void onObserverError(Throwable e, BaseLayerPresenter cls);

    /**
     * 网络异常
     *
     * @param cls 基础Presenter
     */
    void onNetworkError(BaseLayerPresenter cls);
}
