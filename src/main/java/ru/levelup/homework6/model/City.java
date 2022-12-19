package ru.levelup.homework6.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
    private Integer codeCity;
    private Integer codeRegion;
    private String ruCityName;
    private String engCityName;
    private Integer population;
}
