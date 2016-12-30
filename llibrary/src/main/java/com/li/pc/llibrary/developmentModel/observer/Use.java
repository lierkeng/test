package com.li.pc.llibrary.developmentModel.observer;

import org.xutils.common.util.LogUtil;

import static android.R.attr.description;
import static com.li.pc.llibrary.R.drawable.d;

/**
 * author   ：mo
 * data     ：2016/12/11
 * time     ：11:07
 * function :观察者模式使用
 */

public class Use {
    public static void main(String[] args) {
        //声明被观察者
        Observable<Weather> observable = new Observable<Weather>();
        //声明观察者1
        Observer<Weather> observer1 = new Observer<Weather>() {
            @Override
            public void onUpdate(Observable<Weather> observable, Weather data) {
                LogUtil.i("观察者1" + data.toString());
            }
        };
        //声明观察者2
        Observer<Weather> observer2 = new Observer<Weather>() {
            @Override
            public void onUpdate(Observable<Weather> observale, Weather data) {
                LogUtil.i("观察者2" + data.toString());
            }
        };
        //给被观察者注册观察者1
        observable.register(observer1);
//        给被观察者注册观察者2
        observable.register(observer2);
//          数据发生变化
        Weather weather = new Weather("晴转多云");
//        被观察者通知观察者
        observable.notifyObservers(weather);

        Weather weather1 = new Weather("多云转阴");
        observable.notifyObservers(weather1);

        observable.unregister(observer1);

        Weather weather2 = new Weather("台风");
        observable.notifyObservers(weather2);
//        观察者1：Weather{description=’晴转多云’}
//        观察者2：Weather{description=’晴转多云’}
//        观察者1：Weather{description=’多云转阴’}
//        观察者2：Weather{description=’多云转阴’}
//        观察者2：Weather{description=’台风’}
    }
}
