package com.li.pc.llibrary.developmentModel.observer;

/**
 * author   ：mo
 * data     ：2016/12/11
 * time     ：11:01
 * function :观察者模式-观察者
 */

public interface  Observer<T> {
    void onUpdate(Observable<T> observable,T data);
}
