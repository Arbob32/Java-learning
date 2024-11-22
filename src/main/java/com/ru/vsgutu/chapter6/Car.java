package com.ru.vsgutu.chapter6;

public class Car extends BaseVehicle {
    private boolean climateControl;

    public Car(
            String regNumber,
            String brand,
            String model,
            String vinNumber,
            String owner,
            String drivingForceType,
            boolean climateControl) {
        super(regNumber, brand, model, vinNumber, owner, drivingForceType);
        this.climateControl = climateControl;
    }

    public void toggleClimateControl() {
        if (climateControl) {
            // включить
        } else {
            // климат контроля нет
        }
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", климат контроль: " + climateControl;
    }

    public boolean isClimateControl() {
        return climateControl;
    }

    public void setClimateControl(boolean climateControl) {
        this.climateControl = climateControl;
    }
}
