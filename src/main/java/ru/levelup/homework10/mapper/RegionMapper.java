package ru.levelup.homework10.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.levelup.homework9.dto.RegionDto;
import ru.levelup.homework9.model.Region;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper
public interface RegionMapper {

    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "name", source = "entity.name")
    RegionDto toDto(Region entity);

    @Mapping(target = "id", source = "dto.id")
    @Mapping(target = "name", source = "dto.name")
    Region toEntity(RegionDto dto);

    default List<RegionDto> toDtos(List<Region> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    default Optional<RegionDto> toOptionalDto(Optional<Region> entity) {
        return entity.map(this::toDto);
    }
}
