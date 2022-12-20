package ru.levelup.homework6.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
    private Integer id;
    private String ruCityName;
    private String engCityName;
    private Integer population;
    private Integer regionId;
}
