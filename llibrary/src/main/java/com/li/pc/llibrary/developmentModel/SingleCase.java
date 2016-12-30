package com.li.pc.llibrary.developmentModel;

/**
 * author   ：mo
 * data     ：2016/12/11
 * time     ：10:40
 * function : 单例模式
 *
 *
 * 概念：确保一个类只有一个实例，并且自行实例化并向整个系统提供整个实例
 * 优点：
 * 1，对于那些耗内存的类，只实例化一次，大大提高性能，尤其是移动开发中
 * 2，程序运行中，始终保持只有一个实例在内存中
 * <p>
 * volatile:本质是在告诉jvm当前变量在寄存器中的值是不确定的,需要从内存中读取,synchronized则是锁定当前变量,只有当前线程可以访问该变量,其他线程被阻塞住.(首先我们要先意识到有这样的现象,编译器为了加快程序运行的速度,对一些变量的写操作会先在寄存器或者是CPU缓存上进行,最后才写入内存.
 * 而在这个过程,变量的新值对其他线程是不可见的.而volatile的作用就是使它修饰的变量的读写操作都必须在内存中进行!)
 * <p>
 * 双重判断null :如果线程A进入了该代码，线程B 在等待，这是A线程创建完一个实例出来后，线程B 获得锁进入同步代码，实例已经存在，木有必要再创建一个，所以双重判断有必要。
 */

public class SingleCase {

    private static volatile SingleCase instance = null;

    public SingleCase() {
    }

    public static SingleCase getInstance() {
        if (instance == null) {
            synchronized (SingleCase.class) {
                if (instance == null) {
                    instance = new SingleCase();
                }
            }
        }
        return instance;
    }
}
