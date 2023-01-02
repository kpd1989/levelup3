package ru.levelup.homework8.entity;


import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "city")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Validated
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
    @NotBlank
    private Region region;

}
