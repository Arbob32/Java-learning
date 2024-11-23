package com.ru.vsgutu.chapter4.a;

import java.util.Objects;

// Мясников А. Б762-2 7 ВАРИАНТ
public class Computer {
    private final Processor processor;
    private final Ram ram;
    private final HardDrive hardDrive;
    private boolean isOn;

    public Computer(Processor processor, Ram ram, HardDrive hardDrive) {
        this.processor = processor;
        this.ram = ram;
        this.hardDrive = hardDrive;
        this.isOn = false;
    }

    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println("Компьютер был включен.");
        } else {
            System.out.println("Компьютер уже включен.");
        }
    }

    public void turnOff() {
        if (isOn) {
            isOn = false;
            System.out.println("Компьютер был выключен.");
        } else {
            System.out.println("Компьютер уже выключен.");
        }
    }

    public void checkForViruses() {
        if (isOn) {
            System.out.println("Выполняется проверка на вирусы.");
        } else {
            System.out.println("Нельзя выполнить проверку на вирусы, компьютер выключен.");
        }
    }

    public void printHardDriveSize() {
        System.out.println("Размер жесткого диска: " + hardDrive.getCapacity() + " ГБ");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return isOn == computer.isOn
                && Objects.equals(processor, computer.processor)
                && Objects.equals(ram, computer.ram)
                && Objects.equals(hardDrive, computer.hardDrive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(processor, ram, hardDrive, isOn);
    }

    @Override
    public String toString() {
        return "Computer{"
                + "processor="
                + processor
                + ", ram="
                + ram
                + ", hardDrive="
                + hardDrive
                + ", isOn="
                + isOn
                + '}';
    }
}
