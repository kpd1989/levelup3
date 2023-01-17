package ru.levelup.homework9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.levelup.homework9.model.Region;

public interface RegionRepository extends JpaRepository<Region, Integer> {
}
