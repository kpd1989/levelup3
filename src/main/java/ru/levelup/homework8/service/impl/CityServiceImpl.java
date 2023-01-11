package ru.levelup.homework8.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.levelup.homework8.entity.City;
import ru.levelup.homework8.repository.CityRepository;
import ru.levelup.homework8.service.CityService;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    @Override
    public City findById(int id) {
        return cityRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(noRollbackFor = {NullPointerException.class})
    public void create(City city) {
        cityRepository.save(city);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteById(Integer id) {
        cityRepository.deleteById(id);
    }

    @Override
    @Transactional(noRollbackFor = {NullPointerException.class})
    public void update(City city) {
        cityRepository.save(city);
    }
}
