package ru.levelup.homework10.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.levelup.homework10.dto.CityDto;
import ru.levelup.homework10.model.City;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper
public interface CityMapper {

    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "ruCityName", source = "entity.ruCityName")
    @Mapping(target = "enCityName", source = "entity.enCityName")
    @Mapping(target = "population", source = "entity.population")
    @Mapping(target = "region", source = "entity.region")
    CityDto toDto(City entity);

    @Mapping(target = "id", source = "dto.id")
    @Mapping(target = "ruCityName", source = "dto.ruCityName")
    @Mapping(target = "enCityName", source = "dto.enCityName")
    @Mapping(target = "population", source = "dto.population")
    @Mapping(target = "region", source = "dto.region")
    City toEntity(CityDto dto);

    default List<CityDto> toDtos(List<City> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    default Optional<CityDto> toOptionalDto(Optional<City> entity) {
        return entity.map(this::toDto);
    }
}
