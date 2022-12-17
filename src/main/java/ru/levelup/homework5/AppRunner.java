package ru.levelup.homework5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.levelup.homework5.bean.WorkPlace;

@SpringBootApplication
public class AppRunner {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AppRunner.class, args);
        WorkPlace workPlace = context.getBean(WorkPlace.class);
        System.out.println("-=Вычисление n-ого члена последовательности Фибоначчи=-");
        workPlace.start();
    }
}
