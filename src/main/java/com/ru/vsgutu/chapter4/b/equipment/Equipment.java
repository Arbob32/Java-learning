package com.ru.vsgutu.chapter4.b.equipment;

import java.io.Serializable;

public abstract class Equipment implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String name;
    private final double price;
    private final double weight;

    public Equipment(String name, double price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return name + ": " + "Цена = " + price + " руб., " + "Вес = " + weight + " кг";
    }
}
