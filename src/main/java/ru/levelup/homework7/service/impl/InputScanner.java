package ru.levelup.homework7.service.impl;

import org.springframework.stereotype.Service;
import ru.levelup.homework7.service.InputService;

import java.util.Scanner;

@Service
public class InputScanner implements InputService {
    Scanner scanner = new Scanner(System.in);

    @Override
    public String getUserString() {
        String line = null;
        try{
            line = scanner.nextLine();
            if (!line.matches("[а-яА-Яa-zA-Z]+")) {
                throw new NumberFormatException();
            }
        } catch (Exception ignore){
            System.out.println("Не допустимый символ. Повторим.");
            getUserString();
        }
        return line;
    }

    @Override
    public int getUserNumber() {
        int number = 0;
        try{
            number = scanner.nextInt();

        } catch (Exception ignore){
            System.out.println("Не допустимый символ. Повторим.");
            getUserNumber();
        }
        return number;
    }
}
