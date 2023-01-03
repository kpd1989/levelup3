package ru.levelup.homework8.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.levelup.homework8.entity.Region;
import ru.levelup.homework8.service.RegionService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Validated
public class RegionController {

    private final RegionService regionService;

    @PostMapping("/region")
    @ResponseStatus(HttpStatus.CREATED)
    public Region createRegion(@Valid @RequestBody Region region) {
        regionService.create(region);
        return region;
    }

    @GetMapping("/region/{id}")
    public Region findById(@PathVariable int id) {
        return regionService.findById(id);
    }

    @DeleteMapping("/region/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteById(@PathVariable int id) {
        String answer;
        Region region = regionService.findById(id);
        regionService.deleteById(id);
        if (region == null) {
            answer = "Объект для удаления отсутствует";
        } else {
            answer = region + " - удален.";
        }

        return answer;
    }
}
