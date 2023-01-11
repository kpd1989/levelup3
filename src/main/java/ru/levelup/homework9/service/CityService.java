package ru.levelup.homework9.service;

import org.springframework.data.domain.Pageable;
import ru.levelup.homework9.dto.CityDto;
import ru.levelup.homework9.dto.CityPageDto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

public interface CityService {
    List<CityDto> findAll();
    CityPageDto getPage(Pageable pageable);
    Optional<CityDto> getById(@NotEmpty Integer cityId);
    CityDto save(@Valid CityDto city);
    void deleteById(@NotEmpty Integer cityId);
}
