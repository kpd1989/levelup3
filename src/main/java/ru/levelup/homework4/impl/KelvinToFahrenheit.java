package ru.levelup.homework4.impl;

import org.springframework.stereotype.Component;
import ru.levelup.homework4.Converter;
@Component
public class KelvinToFahrenheit implements Converter {
    @Override
    public void convert(double value) {
        System.out.println(value + " К = " +
                (((value-273.15)*9.5)+32) + " F");
    }
}
