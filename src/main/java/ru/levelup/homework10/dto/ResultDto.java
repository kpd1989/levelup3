package ru.levelup.homework10.dto;

import lombok.Data;

@Data
public class ResultDto {
    private boolean success;

    public ResultDto() {
        this.success = true;
    }
}
