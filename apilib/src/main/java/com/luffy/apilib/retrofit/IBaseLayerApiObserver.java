package com.luffy.apilib.retrofit;

/**
 * Created by lvlufei on 2019/7/8
 *
 * @name API请求观察者监听
 * @desc
 */
public interface IBaseLayerApiObserver<M> {

    /**
     * 请求下一步
     *
     * @param m 数据
     */
    void onObserverNext(M m);

    /**
     * 请求异常
     *
     * @param e Throwable
     */
    void onObserverError(Throwable e);

}
