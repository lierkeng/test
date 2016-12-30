package com.li.pc.llibrary.Observer.RxAndroid;

import android.text.TextUtils;

import rx.Observable;
import rx.Subscriber;



/**
 * author   ：mo
 * data     ：2016/12/10
 * time     ：17:31
 * function :正在在订阅
 */

public class RXSubscribe<T> implements Observable.OnSubscribe<T> {
    private T t;
    private String string;
    public RXSubscribe(T t) {
        this.t = t;
    }

    public RXSubscribe(String string) {
        this.string = string;
    }

    @Override
    public void call(Subscriber<? super T> subscriber) {
        if (t==null&&!TextUtils.isEmpty(string)){
            t=(T)string;
            subscriber.onNext(t); // 发送事件
        }else {
            subscriber.onNext(t); // 发送事件
        }

        subscriber.onCompleted(); // 完成事件
    }
}
