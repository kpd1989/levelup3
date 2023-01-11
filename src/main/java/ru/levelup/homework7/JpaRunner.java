package ru.levelup.homework7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.levelup.homework7.bean.WorkWithTables;

@SpringBootApplication
public class JpaRunner {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JpaRunner.class, args);
        WorkWithTables workWithTables = context.getBean(WorkWithTables.class);
        workWithTables.addRegion();
        workWithTables.addCity();
    }
}
