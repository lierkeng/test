package com.li.pc.llibrary.developmentModel.strategy;

/**
 * author   ：mo
 * data     ：2016/12/11
 * time     ：11:50
 * function :策略模式--使用
 */

public class Use {
    public static void main(String[] args) {
        TravelContext travelContext = new TravelContext();//创建一个策略类

        travelContext.setStrategy(new PlaneStrategy());//给策略类添加数据
        travelContext.travel();//执行

        travelContext.setStrategy(new WalkStrategy());
        travelContext.travel();

        travelContext.setStrategy(new SubwayStrategy());
        travelContext.travel();
    }
}
