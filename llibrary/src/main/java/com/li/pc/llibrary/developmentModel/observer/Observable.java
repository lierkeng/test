package com.li.pc.llibrary.developmentModel.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * author   ：mo
 * data     ：2016/12/11
 * time     ：10:58
 * function :观察者模式-被观察者
 * 被观察着，我们希望它能够通用，所以定义成泛型，内部应该暴露出register和unRegister供观察者订阅和取消订阅，至于观察者的保存，
 * 我们用ArrayList即可，另外，当主题发生变化的时候，需要通知观察者来做出响应，还需要一个notifyObservers方法
 */

public class Observable<T> {
    //声明观察者集合
    List<com.li.pc.llibrary.developmentModel.observer.Observer<T>> mObservers = new ArrayList<com.li.pc.llibrary.developmentModel.observer.Observer<T>>();

    /**
     * 注册观察者
     *
     * @param observer
     */
    public void register(Observer<T> observer) {
        if (observer == null) {
            throw new NullPointerException("observer == null");
        }
        synchronized (this) {
            if (!mObservers.contains(observer))
                mObservers.add(observer);
        }
    }

    /**
     * 解除注册
     *
     * @param observer
     */
    public synchronized void unregister(Observer<T> observer) {
        mObservers.remove(observer);
    }

    /**
     * 通知观察者数据有变动
     *
     * @param data
     */
    public void notifyObservers(T data) {
        for (Observer<T> observer : mObservers) {
            observer.onUpdate(this, data);
        }
    }
}
