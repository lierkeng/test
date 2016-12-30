package com.li.pc.llibrary.developmentModel.observer;

/**
 * author   ：mo
 * data     ：2016/12/11
 * time     ：10:56
 * function :观察者模式-实体类
 */

public class Weather {
    private String description;

    public Weather(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "description='" + description + '\'' +
                '}';
    }
}
