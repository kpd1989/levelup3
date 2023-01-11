package ru.levelup.homework7.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "city")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class City {

    @Id
    private Integer id;
    @Column(name = "ru_city_name")
    private String ruCityName;
    @Column(name = "eng_city_name")
    private String enCityName;
    @Column(name = "population")
    private Integer population;
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

}
