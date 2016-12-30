package com.li.pc.llibrary.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * author   ：mo
 * data     ：2016/12/10
 * time     ：15:37
 * function :观察者管理类
 */

public class ObserverManager implements BeObserved {
    private static ObserverManager manager;//管理者
    private List<Observerlistener> list = new ArrayList<>();//观察者接口集合

    /**
     * 单例
     *
     * @return
     */
    public static ObserverManager getInstance() {
        if (null == manager) {
            synchronized (ObserverManager.class) {
                if (null == manager) {
                    manager = new ObserverManager();
                }
            }
        }
        return manager;
    }

    /**
     * 加入监听集合
     *
     * @param observerlistener
     */
    @Override
    public void add(Observerlistener observerlistener) {
        list.add(observerlistener);
    }

    /**
     * 在监听集合中移除
     *
     * @param observerlistener
     */
    @Override
    public void remve(Observerlistener observerlistener) {
        if (list.contains(observerlistener)) {//是否包含
            list.remove(observerlistener);
        }
    }

    /**
     * 通知观察者刷新数据
     *
     * @param string
     */
    @Override
    public void notifyObserver(String string) {
        for (Observerlistener observerlistener : list) {
            observerlistener.observerUpData(string);
        }
    }
}
