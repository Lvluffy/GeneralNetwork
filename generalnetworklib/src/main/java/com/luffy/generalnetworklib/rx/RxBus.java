package com.luffy.generalnetworklib.rx;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * Created by lvlufei on 2018/11/3
 *
 * @desc
 */
public class RxBus {
    private final Subject<Object> rxBus = PublishSubject.create().toSerialized();

    private RxBus() {
    }

    public static RxBus getInstance() {
        return RxBus.RxBusHelper.mRxBus;
    }

    /**
     * 静态内部类实现单例
     */
    private static class RxBusHelper {
        private static final RxBus mRxBus;

        static {
            mRxBus = new RxBus();
        }
    }

    public void send(Object object) {
        rxBus.onNext(object);
    }

    public <T> Observable<T> toObserverable(Class<T> eventType) {
        return rxBus.ofType(eventType);
    }
}
