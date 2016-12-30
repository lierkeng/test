package com.li.pc.llibrary.utils;

import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * author   ：mo
 * data     ：2016/12/22
 * time     ：13:43
 * function :
 */

public class UtilsClickExit {
//    有一个很古老的应用技巧，一直被各种大大小小的app用得乐此不疲，那就是双击返回键退出程序。今天就写写它的实现代码，非常简单而且实用。
//
//    正文
//
//    　　双击返回键退出程序，一般有两种实现思路，一种是用一个布尔值变量来记录按键事件，并通过线程延时来实现效果；另外一种是直接通过记录按键时间计算时间差实现功能，现在就跟大家分享下代码吧、O(∩_∩)O哈哈~
//
//            1、利用线程延时实现
//
//
//    private static boolean mBackKeyPressed = false;//记录是否有首次按键
//
//    @Override
//    public void onBackPressed() {
//        　　if(!mBackKeyPressed){
//            　　　　Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
//            　　　　mBackKeyPressed = true;
//            　　　　new Timer().schedule(new TimerTask() {//延时两秒，如果超出则擦错第一次按键记录
//                　　　　　　@Override
//                　　　　　　public void run() {
//                    　　　　　　　　mBackKeyPressed = false;
//                    　　　　　　}
//                　　　　}, 2000);
//            　　}
//        　　else{//退出程序
//            　　　　this.finish();
//            　　　　System.exit(0);
//            　　}
//    }
//
//    通过 mBackKeyPressed  来记录是否有首次按返回键的记录，如果不存在首次按键记录，则Toast提示，并记录首次按键记录，并启动线程在2秒后擦除该按键记录。如果在线程海内擦除mBackKeyPressed 时又按下返回键，则执行else里面的语句退出程序。
//
//            2、通过计算时间差实现
//
//
//    private long mPressedTime = 0;
//
//    @Override
//    public void onBackPressed() {
//        　　long mNowTime = System.currentTimeMillis();//获取第一次按键时间
//        　　if((mNowTime - mPressedTime) > 2000){//比较两次按键时间差
//            　　　　Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
//            　　　　mPressedTime = mNowTime;
//            　　}
//        　　else{//退出程序
//            　　　　this.finish();
//            　　　　System.exit(0);
//            　　}
//    }
//
//    这里是通过控制时间差来实现功能的，在首次按下返回键时，将会将当期时间赋值给mPressedTime并通过Toast提示用户，在第二次按下返回键时，如果与 mPressedTime记录的时间差值大于2秒则重新刷新mPressedTime的时间，如果小于2秒则执行else的语句退出程序。
//
//    PS:个人比较建议用时间差的方式来实现这个功能，因为代码的简单与稳定性都比线程延时相对好很多。
}
