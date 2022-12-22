package ru.levelup.homework7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.levelup.homework7.entity.City;
import ru.levelup.homework7.entity.Region;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Integer> {

    @Query("select region from Region region " +
            "where region.name = :name")
    List<Region> findByName(String name);

}
