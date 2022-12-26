package ru.levelup.homework8.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.levelup.homework8.entity.City;
import ru.levelup.homework8.entity.Region;
import ru.levelup.homework8.service.CityService;
import ru.levelup.homework8.service.RegionService;

@RestController
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;
    private final RegionService regionService;


    @GetMapping("/city/add")
    public City create(int id, String ruName, String engName, int population, int region_id) {
        Region region = regionService.findById(region_id);
        City city = new City(id, ruName, engName, population, region);
        cityService.create(city);
        return city;
    }

    @GetMapping("/city/find_by_id")
    public City findById(int id) {
        return cityService.findById(id);
    }

    @GetMapping("/city/delete")
    public String deleteById(int id) {
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
