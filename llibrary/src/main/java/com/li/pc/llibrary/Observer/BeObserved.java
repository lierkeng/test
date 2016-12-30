package com.li.pc.llibrary.Observer;

/**
 * author   ：mo
 * data     ：2016/12/10
 * time     ：15:33
 * function :被观察者接口
 */

public interface BeObserved {
    void add(Observerlistener observerlistener);//添加观察者
    void remve(Observerlistener observerlistener);//删除观察者
    void notifyObserver(String string);//通知观察者
}
