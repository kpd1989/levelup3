package ru.levelup.homework7.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.levelup.homework7.entity.City;
import ru.levelup.homework7.repository.CityRepository;
import ru.levelup.homework7.service.CityService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    @Override
    public List<City> findByPopulation(Integer population) {
        return cityRepository.findByPopulation(population);
    }

    @Override
    public List<City> findByPopulationAndRuName(String name, Integer population) {
        return cityRepository.findByRuCityNameAndPopulation(name, population);
    }

    @Override
    public void create(City city) {
        cityRepository.save(city);
    }

    @Override
    public void deleteById(Integer id) {
        cityRepository.deleteById(id);
    }

    @Override
    public void update(City city) {
        cityRepository.save(city);
    }
}
