package ru.levelup.homework7.bean;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.levelup.homework7.entity.City;
import ru.levelup.homework7.entity.Region;
import ru.levelup.homework7.service.InputService;
import ru.levelup.homework7.service.impl.CityServiceImpl;
import ru.levelup.homework7.service.impl.RegionServiceImpl;

@Service
@AllArgsConstructor
public class WorkWithTables {

    RegionServiceImpl regionService;
    CityServiceImpl cityService;
    InputService inputService;

    public void addRegion(){
        System.out.println("Введите код региона");
        int id = inputService.getUserNumber();
        System.out.println("Введите наименование региона");
        String name = inputService.getUserString();
        regionService.create(new Region(id, name));


        exitFromRecursion();
        addRegion();
    }

    public void addCity(){
        System.out.println("Введите код города");
        int id = inputService.getUserNumber();
        System.out.println("Введите название города на русском");
        String ruName = inputService.getUserString();
        System.out.println("Введите название города на английском");
        String engName = inputService.getUserString();
        System.out.println("Введите численность населения");
        int population = inputService.getUserNumber();
        System.out.println("Введите код региона");
        int regId = inputService.getUserNumber();
        Region region = regionService.findById(regId);

        cityService.create(new City(id, ruName, engName, population, region));
        addCity();

        exitFromRecursion();
        addCity();
    }

    void exitFromRecursion(){
        System.out.println("Достаточно? для выхода введите 'exit'");
        String answer = inputService.getUserString();
        if (answer.equals("exit")) {
            return;
        }
    }
}
