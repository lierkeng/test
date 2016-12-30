package com.li.pc.llibrary.developmentModel.template;

/**
 * author   ：mo
 * data     ：2016/12/12
 * time     ：15:28
 * function :模板模式-使用
 * 有一个模板，里面有几个固定的方法，当你想要干别的的时候，继承这个模板，重写对你们用的方法或者更改成你想要他做的事，
 * 基本上就是重写
 */

public class use {
    public static void main(String[] args) {
        Teacher teacher=new Teacher();
        teacher.start();
        System.out.println("-------------");
        Worker worker=new Worker();
        worker.start();
    }
}
