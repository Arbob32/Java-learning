package com.ru.vsgutu.chapter6;

public class Bicycle extends BaseVehicle {

    public Bicycle(String brand, String model, String owner) {
        super(null, brand, model, null, owner, "Мускульная");
    }

    @Override
    public void fillUp() {
        // не требует заправки
    }

    public void adjustBrakes() {
        // тормоза отрегулированы
    }
}
