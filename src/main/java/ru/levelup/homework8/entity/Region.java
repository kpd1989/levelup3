package ru.levelup.homework8.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "region")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Region {
    @Id
    private Integer id;

    @Column(name ="name")
    private String name;
}
