package ru.levelup.homework10.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.levelup.homework9.dto.ResultDto;
import ru.levelup.homework9.service.RegionService;

@RestController
@RequiredArgsConstructor
public class RegionController {

    private final RegionService regionService;

    @DeleteMapping("/region/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        regionService.deleteById(id);
        return ResponseEntity.ok(new ResultDto());
    }

}
