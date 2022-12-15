package ru.levelup.homework5.bean;

import org.springframework.stereotype.Component;
import ru.levelup.homework5.KeypadReader;
import ru.levelup.homework5.StorageSystem;

@Component
public class WorkPlace {
    StorageSystem storageSystem;
    KeypadReader keypadReader;

    public WorkPlace(StorageSystem storageSystem, KeypadReader keypadReader) {
        this.storageSystem = storageSystem;
        this.keypadReader = keypadReader;
    }

    public void start() {
        System.out.println("Введите число (для выхода '0')");

        storageSystem.getElement(keypadReader.getNumber());

        start();
    }
}
