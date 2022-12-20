package ru.levelup.homework6.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class City {
    private Integer id;
    private String ruCityName;
    private String engCityName;

    private Integer population;

    private Integer regionId;

    public City(Integer id, String ruCityName, String engCityName, Integer population, Integer regionId) {
        this.id = id;
        this.ruCityName = ruCityName;
        this.engCityName = engCityName;
        this.population = population;
        this.regionId = regionId;
    }

}
