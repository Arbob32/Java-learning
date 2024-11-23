package com.ru.vsgutu.chapter6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleTest {

    @Test
    public void testGetInfo() {
        Car car = new Car("123", "Toyota", "Corolla", "a001aa", "owner", "benzine", true);
        Bicycle bicycle = new Bicycle("Forward", "model1", "owner2");

        assertTrue(car.isClimateControl());
        assertEquals("Мускульная", bicycle.getDrivingForceType());
        assertNull(bicycle.getRegNumber());
    }
}
