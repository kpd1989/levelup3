package ru.levelup.homework6.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Region {
    private Integer id;
    private String regName;
    private Integer codeCity;
    private City city;

    public Region(Integer id, String regName, Integer codeCity) {
        this.id = id;
        this.regName = regName;
        this.codeCity = codeCity;
    }

}
