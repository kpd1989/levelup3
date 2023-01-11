package ru.levelup.homework8.service;

import ru.levelup.homework8.entity.City;


public interface CityService {


    City findById(int id);

    void create(City city);

    void deleteById(Integer id);

    void update(City city);


}
