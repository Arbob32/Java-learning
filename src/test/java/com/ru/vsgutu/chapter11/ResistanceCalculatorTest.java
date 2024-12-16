package com.ru.vsgutu.chapter11;

import static org.junit.jupiter.api.Assertions.*;

import com.ru.vsgutu.chapter11.a.ResistanceCalculator;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ResistanceCalculatorTest {

    @Test
    void test() {
        List<Double> currents = Arrays.asList(1.0, 2.0, 3.0);
        List<Double> voltages = Arrays.asList(2.0, 4.0, 6.0);
        double expected = 2.0;
        double actual = ResistanceCalculator.calculateResistance(currents, voltages);
        assertEquals(expected, actual);
    }
}
