package ru.levelup.homework9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.levelup.homework9.model.City;


public interface CityRepository extends JpaRepository<City, Integer> {

}
