package ru.levelup.homework7.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.levelup.homework7.entity.Region;
import ru.levelup.homework7.repository.RegionRepository;
import ru.levelup.homework7.service.RegionService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;
    @Override
    public Region findById(Integer id){
        return regionRepository.findById(id).orElse(null);
    }
    @Override
    public List<Region> findByName(String name) {
        return regionRepository.findByName(name);
    }
    @Override
    public Region create(Region region) {
        return regionRepository.save(region);
    }
    @Override
    public void deleteById(Integer id) {
        regionRepository.deleteById(id);
    }
    @Override
    public void update(Region region) {
        regionRepository.save(region);
    }
}
