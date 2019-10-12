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
    void loading(boolean isShow, BaseLayerPresenter cls);

    /**
     * 完成
     *
     * @param cls
     */
    void completed(BaseLayerPresenter cls);

    /**
     * 异常
     *
     * @param e
     * @param cls
     */
    void onError(Throwable e, BaseLayerPresenter cls);
}
