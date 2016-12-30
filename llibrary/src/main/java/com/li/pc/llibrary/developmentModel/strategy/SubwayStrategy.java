package com.li.pc.llibrary.developmentModel.strategy;

/**
 * author   ：mo
 * data     ：2016/12/11
 * time     ：11:45
 * function :策略模式-一般写法
 */

public class SubwayStrategy implements Strategy{

    @Override
    public void travel() {
        System.out.println("subway");
    }

}
