package com.ru.vsgutu.chapter4.a;

import java.util.Objects;

public class Processor {
    private final String model;
    private final double frequency;

    public Processor(String model, double frequency) {
        this.model = model;
        this.frequency = frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Processor processor = (Processor) o;
        return Double.compare(frequency, processor.frequency) == 0
                && Objects.equals(model, processor.model);
    }

    @Override
    public String toString() {
        return "Processor{" + "model='" + model + '\'' + ", frequency=" + frequency + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, frequency);
    }
}
