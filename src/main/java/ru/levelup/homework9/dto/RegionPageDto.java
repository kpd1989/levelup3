package ru.levelup.homework9.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RegionPageDto {

    private List<RegionDto> data;
    private int currentPage;
    private int totalPage;
    private boolean hasNext;
    private boolean hasPrevious;
}
