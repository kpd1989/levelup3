package ru.levelup.homework9.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "city")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {

    @Id
    @Min(0)
    private Integer id;

    @Column(name = "ru_city_name")
    private String ruCityName;

    @Column(name = "eng_city_name")
    private String enCityName;

    @Column(name = "population")
    @Min(0)
    private Integer population;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

}
