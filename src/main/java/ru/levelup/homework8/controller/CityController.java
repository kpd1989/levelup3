package ru.levelup.homework8.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.levelup.homework8.entity.City;
import ru.levelup.homework8.service.CityService;
import ru.levelup.homework8.service.RegionService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Validated
public class CityController {

    private final CityService cityService;

    private final RegionService regionService;

    @PostMapping("/city")
    @ResponseStatus(HttpStatus.CREATED)
    public City createCity (@Valid @RequestBody City city) {
        if (city.getRuCityName().matches("\\d") || city.getEnCityName().matches("\\d")) {
            throw new IllegalArgumentException("Проверьте введенные данные");
        }

        if (regionService.findById(city.getRegion().getId()) == null){
            regionService.create(city.getRegion());
        }

        cityService.create(city);

        return city;
    }

    @GetMapping("/city/{id}")
    public City findById(@PathVariable int id) {
        return cityService.findById(id);
    }

    @DeleteMapping("/city/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
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
