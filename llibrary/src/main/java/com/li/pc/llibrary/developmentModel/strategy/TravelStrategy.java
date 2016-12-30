package com.li.pc.llibrary.developmentModel.strategy;

import org.xutils.common.util.LogUtil;

import static com.li.pc.llibrary.R.drawable.e;

/**
 * author   ：mo
 * data     ：2016/12/11
 * time     ：11:36
 * function : 策略模式-一般写法
 */

public class TravelStrategy {
    enum Strategy{
        WALK,PLANE,SUBWAY
    }
    private Strategy strategy;

    public TravelStrategy(Strategy strategy) {

        this.strategy = strategy;
    }
    public void travel(){
        if (strategy==Strategy.WALK){
            LogUtil.i("walk");
        }else if (strategy==Strategy.PLANE){
            LogUtil.i("plane");
        }else if (strategy==Strategy.SUBWAY){
            LogUtil.i("subway");
        }
    }
    public static void main(String[] args) {
        TravelStrategy walk=new TravelStrategy(Strategy.WALK);
        walk.travel();

        TravelStrategy plane=new TravelStrategy(Strategy.PLANE);
        plane.travel();

        TravelStrategy subway=new TravelStrategy(Strategy.SUBWAY);
        subway.travel();
    }
}
