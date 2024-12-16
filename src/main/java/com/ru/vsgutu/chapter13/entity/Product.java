package com.ru.vsgutu.chapter13.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private String description;
    private Date releaseDate;
    private int groupId;

    public Product(String name, String description, Date releaseDate, int groupId) {
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
        this.groupId = groupId;
    }
}
