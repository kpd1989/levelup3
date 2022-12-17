package ru.levelup.homework5.impl;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import ru.levelup.homework5.StorageSystem;

import java.util.ArrayList;
import java.util.stream.IntStream;

@Service
@ConditionalOnProperty(name = "application.cash.enable", havingValue = "true")
public class ListDataBase implements StorageSystem {
    private static ArrayList<Integer> listBase;

    public ListDataBase(ArrayList<Integer> listBase) {
        listBase.add(0);
        listBase.add(1);
        ListDataBase.listBase = listBase;
    }

    @Override
    public void addElement(int value) {
        IntStream.range(listBase.size(), value)
                .forEach(i -> listBase.add(i, (listBase.get(i - 2)) + (listBase.get(i - 1))));
    }

    @Override
    public void getElement(int value) {
        if (listBase.size() >= value) {
            System.out.println("Эллемент имеется в базе");
        } else {
            System.out.println("Эллемент добавлен в базу");
            addElement(value);
        }
        System.out.println(value + "-й элемент последовательности =" + listBase.get(value - 1)
                + "\n-----------------------");
    }
}
