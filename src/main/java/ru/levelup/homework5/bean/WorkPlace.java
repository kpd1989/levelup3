package ru.levelup.homework5.bean;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.levelup.homework5.KeypadReader;
import ru.levelup.homework5.StorageSystem;

@Component
@AllArgsConstructor
public class WorkPlace {
    StorageSystem storageSystem;
    KeypadReader keypadReader;


    public void start() {
        System.out.println("Введите число (для выхода exit/quit/'0')");
        storageSystem.getElement(keypadReader.getNumber());
        start();
    }
}
