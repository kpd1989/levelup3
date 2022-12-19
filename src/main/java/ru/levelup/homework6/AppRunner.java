package ru.levelup.homework6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.levelup.homework6.dao.CityDao;
import ru.levelup.homework6.dao.RegionDao;
import ru.levelup.homework6.model.Region;

@SpringBootApplication
public class AppRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AppRunner.class, args);
        CityDao cityDao = context.getBean(CityDao.class);
       /* //cityDao.create(new City(3812, 55, "Омск", "Omsk", 1125695));
        cityDao.create(new City(3801, 55, "блабла", "BlaBla", 115));
        System.out.println(cityDao.findAll());

        System.out.println("--------------");
        cityDao.deleteById(3801);
        System.out.println(cityDao.findAll());

        System.out.println("--------------");
        System.out.println(cityDao.getById(3801));
*/
        System.out.println("--------------");
        RegionDao regionDao = context.getBean(RegionDao.class);
        regionDao.create(new Region(24, "Krasn. kray", 391));
        System.out.println(regionDao.findAll());

    }

}
