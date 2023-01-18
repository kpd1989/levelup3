package ru.levelup.homework10.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CityDto {

    @NotNull
    @Size(min = 1, max = 5)
    private Integer id;

    @NotNull
    @Size(min = 1, max = 50)
    private String ruCityName;

    @NotNull
    @Size(min = 1, max = 50)
    private String enCityName;

    @NotNull
    @Min(1)
    private Integer population;

    @NotNull
    private RegionDto region;

    public String getIdStr() {
        return String.format("city_%s", id);
    }
}
