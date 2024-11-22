package com.ru.vsgutu.chapter4.a;

import java.util.Objects;

public class Ram {
    private final int size;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ram ram = (Ram) o;
        return size == ram.size;
    }

    @Override
    public String toString() {
        return "Ram{" + "size=" + size + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(size);
    }

    public Ram(int size) {
        this.size = size;
    }
}
