package ru.levelup.homework6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.levelup.homework6.dao.CityDao;
import ru.levelup.homework6.dao.RegionDao;
import ru.levelup.homework6.model.City;
import ru.levelup.homework6.model.Region;

@SpringBootApplication
public class AppRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AppRunner.class, args);
        CityDao cityDao = context.getBean(CityDao.class);
        //  cityDao.create(new City(3812, "Омск", "Omsk", 1125695, null));
        cityDao.create(new City(1500, "блабла", "BlaBla", 115,55));
        System.out.println(cityDao.findAll());

        System.out.println("------------del");
        //cityDao.deleteById(3809);

        System.out.println("-------------3812");
        System.out.println(cityDao.getById(3812));
        System.out.println("--------------all");
        System.out.println(cityDao.findAll());
        System.out.println("-----------reg");
        RegionDao regionDao = context.getBean(RegionDao.class);
        //   regionDao.create(new Region(55, "Omsk region"));
        System.out.println(regionDao.findAll());
        System.out.println(regionDao.getById(24));
    }

}
