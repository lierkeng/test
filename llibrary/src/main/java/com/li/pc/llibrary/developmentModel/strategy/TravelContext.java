package com.li.pc.llibrary.developmentModel.strategy;

/**
 * author   ：mo
 * data     ：2016/12/11
 * time     ：11:46
 * function : 策略模式--包装策略的类，用来吊桶策略中的接口
 */

public class TravelContext {
    Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    public void travel(){
        if (strategy!=null){
            strategy.travel();
        }
    }
}
