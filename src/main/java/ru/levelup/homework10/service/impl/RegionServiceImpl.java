package ru.levelup.homework10.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.levelup.homework10.dto.RegionDto;
import ru.levelup.homework10.dto.RegionPageDto;
import ru.levelup.homework10.mapper.RegionMapper;
import ru.levelup.homework10.model.Region;
import ru.levelup.homework10.repository.RegionRepository;
import ru.levelup.homework10.security.Authorities;
import ru.levelup.homework10.service.RegionService;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;
    private final RegionMapper regionMapper;
    private final Authorities authorities;

    @Override
    @Transactional(readOnly = true)
    public List<RegionDto> findAll() {
        return regionMapper.toDtos(regionRepository.findAll());
    }

    @Override
    public RegionPageDto getPage(Pageable pageable) {
        Page<Region> currentPage = regionRepository.findAll(pageable);
        return new RegionPageDto(regionMapper.toDtos(currentPage.getContent()),
                currentPage.getNumber(),
                currentPage.getTotalPages(),
                currentPage.hasNext(),
                currentPage.hasPrevious(),
                authorities.isAdmin());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<RegionDto> getById(@NotEmpty Integer regionId) {
        return regionMapper.toOptionalDto(regionRepository.findById(regionId));
    }

    @Override
    @Transactional
    public RegionDto save(@Valid RegionDto region) {
        return regionMapper.toDto(regionRepository.save(regionMapper.toEntity(region)));
    }

    @Override
    @Transactional
    public void deleteById(@NotEmpty Integer regionId) {
        regionRepository.deleteById(regionId);
    }
}
