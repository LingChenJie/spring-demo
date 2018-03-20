package com.paxsz.bean2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("car2")
public class Car {
    @Value("玛莎拉蒂")
    private String name;
    @Value("粉红色")
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car [name=" + name + ", color=" + color + "]";
    }

}
