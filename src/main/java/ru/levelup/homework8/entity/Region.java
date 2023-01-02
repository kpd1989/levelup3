package ru.levelup.homework8.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "region")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Region {
    @Id
    @Min(0)
    private Integer id;

    @Column(name ="name")
    @NotBlank
    private String name;
}
