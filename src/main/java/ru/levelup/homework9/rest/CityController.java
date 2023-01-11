package ru.levelup.homework9.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.levelup.homework9.dto.ResultDto;
import ru.levelup.homework9.service.CityService;

@RestController
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @DeleteMapping("/city/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        cityService.deleteById(id);
        return ResponseEntity.ok(new ResultDto());
    }

}
