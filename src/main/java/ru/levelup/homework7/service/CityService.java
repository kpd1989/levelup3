package ru.levelup.homework7.service;

import ru.levelup.homework7.entity.City;

import java.util.List;

public interface CityService {

    List<City> findByPopulation(Integer population);

    List<City> findByPopulationAndRuName(String name, Integer population);

    void create(City city);

    void deleteById(Integer id);

    void update(City city);



}
