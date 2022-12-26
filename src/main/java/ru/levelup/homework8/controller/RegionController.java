package ru.levelup.homework8.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.levelup.homework8.entity.Region;
import ru.levelup.homework8.service.RegionService;

@RestController
@RequiredArgsConstructor
public class RegionController {

    private final RegionService regionService;

    @GetMapping("/region")
    public String regionApp() {
        return "/add \n" +
               " id, name \n" +
               "\n" +
               "/find_by_id \n" +
               " id\n" +
               "\n" +
               "/delete \n" +
               " id";
    }

    @PostMapping("/region/add")
    public Region create(int id, String name) {
        Region region = new Region(id, name);
        regionService.create(region);
        return region;
    }

    @GetMapping("/region/find_by_id")
    public Region findById(int id) {
        return regionService.findById(id);
    }

    @DeleteMapping("/region/delete")
    public String deleteById(int id) {
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
