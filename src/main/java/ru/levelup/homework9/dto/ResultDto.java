package ru.levelup.homework9.dto;

import lombok.Data;

@Data
public class ResultDto {
    private boolean success;

    public ResultDto() {
        this.success = true;
    }
}
