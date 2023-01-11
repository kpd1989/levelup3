package ru.levelup.homework8.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.levelup.homework8.entity.Region;
import ru.levelup.homework8.repository.RegionRepository;
import ru.levelup.homework8.service.RegionService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;

    @Override
    public Region findById(Integer id) {
        return regionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Region> findByName(String name) {
        return regionRepository.findByName(name);
    }

    @Override
    @Transactional(noRollbackFor = {NullPointerException.class})
    public Region create(Region region) {
        return regionRepository.save(region);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteById(Integer id) {
        regionRepository.deleteById(id);
    }

    @Override
    @Transactional(noRollbackFor = {NullPointerException.class})
    public void update(Region region) {
        regionRepository.save(region);
    }
}
