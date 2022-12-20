package ru.levelup.homework6.dao;

import ru.levelup.homework6.model.City;
import ru.levelup.homework6.model.Region;

import java.util.List;
import java.util.Optional;

public interface RegionDao {
    List<Region> findAll();
    Optional<Region> getById(int regionId);
    int create(Region region);
    void update(Region region);
    void deleteById(int regionId);
}
