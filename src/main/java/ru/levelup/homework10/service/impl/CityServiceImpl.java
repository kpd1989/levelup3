package ru.levelup.homework10.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.levelup.homework10.dto.CityDto;
import ru.levelup.homework10.dto.CityPageDto;
import ru.levelup.homework10.mapper.CityMapper;
import ru.levelup.homework10.mapper.RegionMapper;
import ru.levelup.homework10.model.City;
import ru.levelup.homework10.repository.CityRepository;
import ru.levelup.homework10.repository.RegionRepository;
import ru.levelup.homework10.security.Authorities;
import ru.levelup.homework10.service.CityService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;
    private final RegionRepository regionRepository;
    private final RegionMapper regionMapper;
    private final Authorities authorities;

    @Override
    @Transactional(readOnly = true)
    public List<CityDto> findAll() {
        return cityMapper.toDtos(cityRepository.findAll());
    }

    @Override
    public CityPageDto getPage(Pageable pageable) {
        Page<City> currentPage = cityRepository.findAll(pageable);
        return new CityPageDto(cityMapper.toDtos(currentPage.getContent()),
                currentPage.getNumber(),
                currentPage.getTotalPages(),
                currentPage.hasNext(),
                currentPage.hasPrevious(),
                authorities.isAdmin());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CityDto> getById(Integer cityId) {
        return cityMapper.toOptionalDto(cityRepository.findById(cityId));
    }

    @Override
    @Transactional
    public CityDto save(CityDto city) {
        regionMapper.toDto(regionRepository.save(regionMapper.toEntity(city.getRegion())));
        return cityMapper.toDto(cityRepository.save(cityMapper.toEntity(city)));
    }

    @Override
    @Transactional
    public void deleteById(Integer cityId) {
        cityRepository.deleteById(cityId);
    }
}
