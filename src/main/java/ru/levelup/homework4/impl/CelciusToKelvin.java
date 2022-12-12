package ru.levelup.homework4.impl;

import org.springframework.stereotype.Component;
import ru.levelup.homework4.Converter;

@Component
public class CelciusToKelvin implements Converter {
    @Override
    public void convert(double value) {
        System.out.println(value + " С = " +
                (value+273.15) + "K");
    }
}
