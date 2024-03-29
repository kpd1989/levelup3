package ru.levelup.homework10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import ru.levelup.homework10.model.City;

import static ru.levelup.homework10.security.Authorities.ADMIN;

@PreAuthorize("isAuthenticated()")
public interface CityRepository extends JpaRepository<City, Integer> {

    @Secured(ADMIN)
    City save(City city);

    @Secured(ADMIN)
    void delete(City city);

}
