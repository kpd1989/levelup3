package ru.levelup.homework10.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.levelup.homework9.dto.RegionDto;

import java.util.List;

@Data
@AllArgsConstructor
public class RegionPageDto {

    private List<RegionDto> data;
    private int currentPage;
    private int totalPage;
    private boolean hasNext;
    private boolean hasPrevious;
    private boolean admin;
}
