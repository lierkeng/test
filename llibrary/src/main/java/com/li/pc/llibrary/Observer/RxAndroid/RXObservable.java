package com.li.pc.llibrary.Observer.RxAndroid;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

/**
 * author   ：mo
 * data     ：2016/12/10
 * time     ：16:55
 * function :被观察者
 */

public class RXObservable {
    /**
     * 注册观察
     * 即，我同意你观察我了
     *
     * @param t
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> Observable getObservable(T t) {
        Observable<T> observable = Observable.create(new RXSubscribe<T>(t));//创建观察后的指令
//        Observable<String> observable = Observable.create(getOnSubscribe(string));
        observable.observeOn(AndroidSchedulers.mainThread());
        return observable;
    }


    /**
     * RX观察-正在发生时的动作
     *
     * @param string
     * @return
     */
    public static Observable.OnSubscribe getOnSubscribe(final String string) {
        Observable.OnSubscribe obvervable = new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext(string); // 发送事件
                subscriber.onCompleted(); // 完成事件
            }
        };
        return obvervable;
    }

}
