package ru.levelup.homework10.service;

import org.springframework.data.domain.Pageable;
import ru.levelup.homework10.dto.RegionDto;
import ru.levelup.homework10.dto.RegionPageDto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

public interface RegionService {
    List<RegionDto> findAll();

    RegionPageDto getPage(Pageable pageable);

    Optional<RegionDto> getById(@NotEmpty Integer regionId);

    RegionDto save(@Valid RegionDto region);

    void deleteById(@NotEmpty Integer regionId);
}
