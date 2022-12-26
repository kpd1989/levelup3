package ru.levelup.homework8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.levelup.homework8.entity.City;


public interface CityRepository extends JpaRepository<City,Integer> {

}
