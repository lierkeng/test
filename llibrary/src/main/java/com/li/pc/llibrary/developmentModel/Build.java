package com.li.pc.llibrary.developmentModel;

/**
 * author   ：mo
 * data     ：2016/12/11
 * time     ：10:44
 * function :build模式
 *
 *
 * 在Builder类中定义了一份跟Build类一样的属性通过一系列的成员函数进行赋值，但是返回的都是this,最后提供了一个build函数来创建Build对象，对应的在Build的构造函数中，
 * 传入了Builder对象，然后依次对自己的成员变量进行赋值。此外，Builder的成员函数返回的都是this的另一个作用就是让他支持链式调用，使代码可读性大大增强
 * <p>
 * 使用：Build.Builder builder=new Build.Builder();
 * Build person=builder
 * .name("张三")
 * .age(18)
 * .height(178.5)
 * .weight(67.4)
 * .build();
 * <p>
 * 运用：
 * 1、对话框创建
 * AlertDialog.Builder builder=new AlertDialog.Builder(this);
 * AlertDialog dialog=builder.setTitle("标题")
 * .setIcon(android.R.drawable.ic_dialog_alert)
 * .setView(R.layout.myview)
 * .setPositiveButton(R.string.positive, new DialogInterface.OnClickListener() {
 *
 * @Override public void onClick(DialogInterface dialog, int which) {
 * <p>
 * }
 * })
 * .setNegativeButton(R.string.negative, new DialogInterface.OnClickListener() {
 * @Override public void onClick(DialogInterface dialog, int which) {
 * <p>
 * }
 * })
 * .create();
 * dialog.show();
 * 2、Gson中的GsonBuilder
 * GsonBuilder builder=new GsonBuilder();
 * Gson gson=builder.setPrettyPrinting()
 * .disableHtmlEscaping()
 * .generateNonExecutableJson()
 * .serializeNulls()
 * .create();
 * 3、网络框架OKHttp
 * Request.Builder builder=new Request.Builder();
 * Request request=builder.addHeader("","")
 * .url("")
 * .post(body)
 * .build();
 * <p>
 * <p>
 * 总结：定义一个静态内部类Builder，内部成员变量跟外部一样
 * <p>
 * Builder通过一系列方法给成员变量赋值，并返回当前对象（this）
 * <p>
 * Builder类内部提供一个build方法方法或者create方法用于创建对应的外部类，该方法内部调用了外部类的一个私有化构造方法，该构造方法的参数就是内部类Builder
 * <p>
 * 外部类提供一个私有化的构造方法供内部类调用，在该构造函数中完成成员变量的赋值
 */

public class Build {

    private String name;
    private int age;
    private double height;
    private double weight;

    private Build(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.height = builder.height;
        this.weight = builder.weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    static class Builder {
        private String name;
        private int age;
        private double height;
        private double weight;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder height(double height) {
            this.height = height;
            return this;
        }

        public Builder weight(double weight) {
            this.weight = weight;
            return this;
        }

        public Build build() {
            return new Build(this);
        }
    }
}
