package ru.levelup.homework8.service;

import ru.levelup.homework8.entity.Region;

import java.util.List;

public interface RegionService {
    List<Region> findByName(String name);

    Region findById(Integer id);

    Region create(Region region);

    void deleteById(Integer id);

    void update(Region region);
}
