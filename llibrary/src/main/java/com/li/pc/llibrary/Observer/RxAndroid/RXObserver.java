package com.li.pc.llibrary.Observer.RxAndroid;

import org.xutils.common.util.LogUtil;

import rx.Observer;



/**
 * author   ：mo
 * data     ：2016/12/10
 * time     ：16:37
 * function :观察者、订阅者、执行人，接收信息做出相应的操作，
 */

public class RXObserver<T> implements Observer<T> {
    /**
     * 执行完
     */
    @Override
    public void onCompleted() {
        LogUtil.i("执行完");
    }

    /**
     * 执行中出错了
     *
     * @param e
     */
    @Override
    public void onError(Throwable e) {
        LogUtil.i("执行中出错了");
    }

    /**
     * 执行中
     *
     * @param s
     */
    @Override
    public void onNext(T s) {
        LogUtil.i("执行中");
    }
}
