package com.ru.vsgutu.chapter13.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParameterGroup {
    private int id;
    private String name;
    private int productGroupId;

    public ParameterGroup(String name, int productGroupId) {
        this.name = name;
        this.productGroupId = productGroupId;
    }
}
