package ru.levelup.homework7.service;

import ru.levelup.homework7.entity.Region;

import java.util.List;

public interface RegionService {
    List<Region> findByName(String name);

    Region findById(Integer id);

    Region create(Region region);

    void deleteById(Integer id);

    void update(Region region);
}
