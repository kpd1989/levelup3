package ru.levelup.homework9.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name = "region")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Region {
    @Id
    @Min(0)
    private Integer id;

    @Column(name = "name")
    private String name;
}
