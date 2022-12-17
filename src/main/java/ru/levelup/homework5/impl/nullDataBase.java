package ru.levelup.homework5.impl;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import ru.levelup.homework5.StorageSystem;

@Service
@ConditionalOnProperty(name = "application.cash.enable", havingValue = "false", matchIfMissing = true)
public class nullDataBase implements StorageSystem {

    @Override
    public void addElement(int value) {
    }

    @Override
    public void getElement(int value) {
        int result;
        if (value <= 1) {
            result= 0;
        } else if (value == 2) {
            result= 1;
        } else  {
            result = (value - 1) + (value - 2);
        }
        System.out.println(value + "-й элемент последовательности =" + result
                + "\n-----------------------");
    }
}