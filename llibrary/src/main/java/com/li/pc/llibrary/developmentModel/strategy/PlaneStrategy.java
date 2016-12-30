package com.li.pc.llibrary.developmentModel.strategy;

/**
 * author   ：mo
 * data     ：2016/12/11
 * time     ：11:44
 * function :策略接口-根据不同的事件来实现接口
 */

public class PlaneStrategy implements Strategy{

    @Override
    public void travel() {
        System.out.println("plane");
    }

}
