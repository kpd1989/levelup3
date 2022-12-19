package ru.levelup.homework6.dao;

import ru.levelup.homework6.model.City;

import java.util.List;
import java.util.Optional;


public interface CityDao {
    List<City> findAll();

    Optional<City> getById(int codeCity);

    void create(City city);

    void update(City city);

    void deleteById(int codeCity);

}
