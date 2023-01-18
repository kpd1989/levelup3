package ru.levelup.homework10.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RegionDto {

    @NotNull
    @Size(min = 1, max = 3)
    private Integer id;

    @NotNull
    @Size(min = 1, max = 50)
    private String name;

    public String getIdStr() {
        return String.format("region_%s", id);
    }
}
