package ru.levelup.homework10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.annotation.Secured;
import ru.levelup.homework9.model.City;

import static ru.levelup.homework9.security.Authorities.ADMIN;


public interface CityRepository extends JpaRepository<City, Integer> {

    @Secured(ADMIN)
    City save(City city);

    @Secured(ADMIN)
    void delete(City city);

}
