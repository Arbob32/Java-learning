package com.ru.vsgutu.chapter13.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductParameter {
    private int productId;
    private int parameterId;
    private String value;
}
