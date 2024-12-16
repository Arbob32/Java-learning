package com.ru.vsgutu.chapter13.projection;

import java.sql.Date;
import lombok.Data;

@Data
public class ProductWithParameters {
    private int id;
    private String name;
    private String description;
    private Date releaseDate;
    private String parameterName;
    private String unitOfMeasurement;
    private String value;
}
