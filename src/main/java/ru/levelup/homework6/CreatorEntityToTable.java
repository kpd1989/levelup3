package ru.levelup.homework6;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.levelup.homework6.dao.CityDao;
import ru.levelup.homework6.dao.RegionDao;
import ru.levelup.homework6.model.City;
import ru.levelup.homework6.model.Region;

@Service
@RequiredArgsConstructor
public class CreatorEntityToTable {

    KeypadReader keypadReader;
    CityDao cityDao;
    RegionDao regionDao;

    public void getCity(){
        System.out.println("Введите код города");
        int id = keypadReader.getNumber();
        System.out.println("Название города на русском");
        String ruName = keypadReader.getString();
        System.out.println("Название города на английском");
        String engName = keypadReader.getString();
        System.out.println("Население");
        int population = keypadReader.getNumber();
        System.out.println("код региона");
        int regionId = keypadReader.getNumber();
        Region region = regionDao.getById(regionId).orElse(null);
        cityDao.create(new City(id,ruName, engName, population, region));

        exitRequrs();
        getCity();
    }

    public void getRegion(){
        System.out.println("Введите код города");
        int id = keypadReader.getNumber();
        System.out.println("Название города на русском");
        String name = keypadReader.getString();

        regionDao.create(new Region(id, name));
        exitRequrs();
        getRegion();
    }

    private void exitRequrs(){
        System.out.println("Достаточно? Для выхода наберите 'q'");
        String answer = keypadReader.getString();
        if (answer.equals("q")) {
            return;
        }
    }

}
