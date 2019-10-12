package com.luffy.generalnetworklib.api.retrofit;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by lvlufei on 2018/11/3
 *
 * @desc Http请求观察者
 */
public abstract class BaseLayerApiObserver<T> implements Observer<T>,
        IBaseLayerApiObserver<T> {

    @Override
    public void onSubscribe(@NonNull Disposable d) {
    }

    @Override
    public void onNext(T t) {
        cacheNetworkData(t);
        next(t);
    }

    @Override
    public void onError(Throwable e) {
        error(e);
    }

    @Override
    public void onComplete() {
        completed();
    }
}
