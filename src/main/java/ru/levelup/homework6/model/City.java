package ru.levelup.homework6.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class City {
    private Integer id;
    private String ruCityName;
    private String engCityName;

    private Integer population;

    private Region region;

}
