package ru.levelup.homework8.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.levelup.homework8.entity.City;
import ru.levelup.homework8.service.CityService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Validated
public class CityController {

    private final CityService cityService;

    @PostMapping("/city")
    public City createCity (@Valid @RequestBody City city) {
        cityService.create(city);
        return city;
    }

    @GetMapping("/city/{id}")
    public City findById(@PathVariable int id) {
        return cityService.findById(id);
    }

    @DeleteMapping("/city/{id}")
    public String deleteById(@PathVariable int id) {
        String answer;
        City city = cityService.findById(id);
        cityService.deleteById(id);

        if (city==null){
            answer = "Объект для удаления отсутствует";
        } else {
            answer = city + " - удален.";
        }

        return answer;
    }
}
