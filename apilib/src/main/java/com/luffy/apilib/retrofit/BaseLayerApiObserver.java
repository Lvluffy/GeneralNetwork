package com.luffy.apilib.retrofit;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by lvlufei on 2018/11/3
 *
 * @desc API请求观察者
 */
public abstract class BaseLayerApiObserver<M> implements Observer<M>,
        IBaseLayerApiObserver<M>,
        IBaseLayerApiData<M> {

    @Override
    public void onSubscribe(@NonNull Disposable d) {
    }

    @Override
    public void onNext(M m) {
        onCacheData(m);
        onObserverNext(m);
    }

    @Override
    public void onError(Throwable e) {
        onObserverError(e);
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onCacheData(M m) {

    }
}
