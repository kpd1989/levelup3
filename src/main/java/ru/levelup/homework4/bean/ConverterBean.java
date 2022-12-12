package ru.levelup.homework4.bean;

import org.springframework.stereotype.Component;
import ru.levelup.homework4.Converter;

@Component
public class ConverterBean {
    private static Converter converter;

    private ConverterBean(Converter celciusToFahrenheit) {
        this.converter = celciusToFahrenheit;
    }
    public void convert(double value){
        converter.convert(value);
    }
}
