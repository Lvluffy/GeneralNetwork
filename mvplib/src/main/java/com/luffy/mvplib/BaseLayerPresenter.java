package com.luffy.mvplib;

/**
 * Created by lvlufei on 2018/11/3
 *
 * @desc MVP模式开发之Presenter
 */
public abstract class BaseLayerPresenter<V extends BaseLayerView> {
    protected V view;

    public BaseLayerPresenter(V view) {
        attachView(view);
    }

    private void attachView(V view) {
        this.view = view;
    }

    public void detachView() {
        if (this.view != null) {
            this.view = null;
        }
    }

    /**
     * 请求模拟数据
     */
    public abstract void requestSimulateData();
}
