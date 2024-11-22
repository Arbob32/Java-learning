package com.ru.vsgutu.chapter6;

public abstract class BaseVehicle implements Vehicle {
    protected String regNumber;
    protected String brand;
    protected String model;
    protected String vinNumber;
    protected String owner;
    protected String drivingForceType;

    public BaseVehicle(
            String regNumber,
            String brand,
            String model,
            String vinNumber,
            String owner,
            String drivingForceType) {
        this.regNumber = regNumber;
        this.brand = brand;
        this.model = model;
        this.vinNumber = vinNumber;
        this.owner = owner;
        this.drivingForceType = drivingForceType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getDrivingForceType() {
        return drivingForceType;
    }

    public void setDrivingForceType(String drivingForceType) {
        this.drivingForceType = drivingForceType;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String getInfo() {
        return String.format(
                "Марка: %s, Модель: %s, Рег. номер: %s, VIN: %s, Владелец: %s, Тип движущей силы: %s",
                brand, model, regNumber, vinNumber, owner, drivingForceType);
    }

    @Override
    public void fillUp() {
        // заправлено
    }

    @Override
    public void repair() {
        // отремонтировано
    }

    @Override
    public void serve() {
        // обслужано
    }

    @Override
    public void doTechInspection() {
        // тех. осмотрено
    }
}
