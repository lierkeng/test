package com.li.pc.llibrary.developmentModel.template;

/**
 * author   ：mo
 * data     ：2016/12/12
 * time     ：15:26
 * function :模板模式-通用的方法
 */

public abstract class comming {
    protected void eat(){
        System.out.println("吃饭");
    }

    protected void dosomething(){
        System.out.println("上班");
    }

    protected void gohome(){
        System.out.println("回家");
    }

    protected void sleep(){
        System.out.println("睡觉");
    }

    public final void start(){
        eat();
        dosomething();
        gohome();
        sleep();
    }
}
