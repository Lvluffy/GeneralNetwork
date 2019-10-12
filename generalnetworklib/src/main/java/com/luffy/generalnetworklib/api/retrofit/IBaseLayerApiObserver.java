package com.luffy.generalnetworklib.api.retrofit;

/**
 * Created by lvlufei on 2019/7/8
 *
 * @name Http请求观察者-回调
 * @desc
 */
public interface IBaseLayerApiObserver<T> {
    /**
     * 缓存网络数据
     *
     * @param d 数据
     */
    void cacheNetworkData(T d);

    /**
     * 请求下一步
     *
     * @param d
     */
    void next(T d);

    /**
     * 请求异常
     *
     * @param e
     */
    void error(Throwable e);

    /**
     * 请求完成
     */
    void completed();
}
