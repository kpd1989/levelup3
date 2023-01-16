package ru.levelup.homework10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.annotation.Secured;
import ru.levelup.homework10.model.Region;

import static ru.levelup.homework10.security.Authorities.ADMIN;

public interface RegionRepository extends JpaRepository<Region, Integer> {
    @Secured(ADMIN)
    Region save(Region region);

    @Secured(ADMIN)
    void delete(Region region);
}
