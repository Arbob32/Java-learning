package com.ru.vsgutu.chapter13.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Parameter {
    private int id;
    private String name;
    private String unitOfMeasurement;
    private int parameterGroupId;

    public Parameter(String name, String unitOfMeasurement, int parameterGroupId) {
        this.name = name;
        this.unitOfMeasurement = unitOfMeasurement;
        this.parameterGroupId = parameterGroupId;
    }
}
