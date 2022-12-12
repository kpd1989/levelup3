package ru.levelup.homework4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.levelup.homework4.bean.ConverterBean;
import ru.levelup.homework4.config.AppConfig;

public class ConverterRunner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ConverterBean converter = context.getBean(ConverterBean.class);
        converter.convert(100);
    }
}
