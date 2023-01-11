package ru.levelup.homework9.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.levelup.homework9.dto.CityDto;
import ru.levelup.homework9.dto.CityPageDto;
import ru.levelup.homework9.service.CityService;
import ru.levelup.homework9.validator.PositiveOrZero;

import javax.validation.constraints.Positive;

@Controller
@Validated
@RequiredArgsConstructor
public class CityPageController {

    private final CityService cityService;

    @GetMapping("/cities")
    public String index(Model model,
                        @PositiveOrZero(originValue = 15) @RequestParam(required = false, defaultValue = "0") Integer page,
                        @Positive @RequestParam(required = false, defaultValue = "5") Integer size) {

        CityPageDto allCity = cityService.getPage(PageRequest.of(page, size));
        model.addAttribute("cities", allCity);
        return "city/cities";
    }

    @GetMapping("/city/add")
    public String newCity(Model model) {
        return "city/city";
    }

    @GetMapping("/city/edit")
    public String currenCity(@RequestParam("id") Integer cityId, Model model) {
        CityDto currentCity = cityService.getById(cityId)
                .orElseThrow(() -> new IllegalArgumentException("Non existed city"));
        model.addAttribute("genre", currentCity);
        return "city/city";
    }

    @PostMapping("/city/save")
    public String saveCity(CityDto city) {
        cityService.save(city);
        return "redirect:/cities";
    }
}
