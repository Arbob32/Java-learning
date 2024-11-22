package com.ru.vsgutu.chapter4.a;

import java.util.Objects;

public class HardDrive {
    private final int capacity;

    public HardDrive(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HardDrive hardDrive = (HardDrive) o;
        return capacity == hardDrive.capacity;
    }

    @Override
    public String toString() {
        return "HardDrive{" + "capacity=" + capacity + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(capacity);
    }
}
