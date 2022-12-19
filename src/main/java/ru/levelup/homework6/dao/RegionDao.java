package ru.levelup.homework6.dao;

import ru.levelup.homework6.model.City;
import ru.levelup.homework6.model.Region;

import java.util.List;

public interface RegionDao {
    List<Region> findAll();
    int create(Region region);
    void update(Region region);
}
