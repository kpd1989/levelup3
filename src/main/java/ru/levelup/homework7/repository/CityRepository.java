package ru.levelup.homework7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.levelup.homework7.entity.City;

import java.util.List;

public interface CityRepository extends JpaRepository<City,Integer> {

    @Query("select city from City city " +
    "where city.population >= :population")
    List<City> findByPopulation(Integer population);

    List<City> findByRuCityNameAndPopulation(String ruCityName, Integer population);
}
