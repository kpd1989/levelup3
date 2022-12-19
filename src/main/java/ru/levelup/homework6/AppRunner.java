package ru.levelup.homework6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.levelup.homework6.dao.CityDao;

@SpringBootApplication
public class AppRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AppRunner.class, args);
        CityDao cityDao = context.getBean(CityDao.class);
       // cityDao.create(new City(3812, 55, "Омск", "Omsk", 1125695));
       // RegionDao regionDao = context.getBean(RegionDao.class);

        System.out.println(cityDao.findAll());


    }

}
