package com.ru.vsgutu.chapter13.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductGroup {
    private int id;
    private String name;

    public ProductGroup(String name) {
        this.name = name;
    }
}
