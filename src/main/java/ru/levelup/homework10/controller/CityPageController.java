package ru.levelup.homework10.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.levelup.homework10.dto.CityDto;
import ru.levelup.homework10.service.CityService;

@Controller
@RequiredArgsConstructor
public class CityPageController {

    private final CityService cityService;

    @GetMapping("/cities")
    public String allCities() {
        return "city/cities";
    }

    @GetMapping("/city/add")
    public String newCity() {
        return "city/city";
    }

    @GetMapping("/city/edit")
    public String currenCity(@RequestParam("id") Integer cityId, Model model) {
        CityDto currentCity = cityService.getById(cityId)
                .orElseThrow(() -> new IllegalArgumentException("Non existed city"));
        model.addAttribute("city", currentCity);
        return "city/city";
    }

    @PostMapping("/city/save")
    public String saveCity(CityDto city) {
        cityService.save(city);
        return "redirect:/cities";
    }
}
