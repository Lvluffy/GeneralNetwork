package com.luffy.apilib.retrofit;

/**
 * Created by lvlufei on 2019/12/3
 *
 * @name API请求数据监听
 * @desc
 */
public interface IBaseLayerApiData<M> {
    /**
     * 缓存数据
     *
     * @param m 数据
     */
    void onCacheData(M m);
}
