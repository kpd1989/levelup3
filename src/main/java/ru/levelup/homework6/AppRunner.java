package ru.levelup.homework6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.levelup.homework6.dao.CityDao;
import ru.levelup.homework6.dao.RegionDao;

@SpringBootApplication
public class AppRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AppRunner.class, args);
        CityDao cityDao = context.getBean(CityDao.class);
        RegionDao regionDao = context.getBean(RegionDao.class);
        CreatorEntityToTable creatorEntityToTable = context.getBean(CreatorEntityToTable.class);
        creatorEntityToTable.getCity();
        creatorEntityToTable.getRegion();

        System.out.println(regionDao.findAll());
        System.out.println(cityDao.findAll());
    }

}
