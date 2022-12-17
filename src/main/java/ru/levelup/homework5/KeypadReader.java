package ru.levelup.homework5;

import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class KeypadReader {
    int value;
    private final Scanner scanner = new Scanner(System.in);

    public int getNumber() {
        String result = scanner.nextLine();

        if (result.equals("exit") || result.equals("quit") || result.equals("0")) {
            System.exit(1);
        }

        try {
            value = Integer.parseInt(result);
        } catch (NumberFormatException ex) {
            System.out.println("Не допустимый символ. Повторим.");
            getNumber();
        }

        return value;
    }
}
