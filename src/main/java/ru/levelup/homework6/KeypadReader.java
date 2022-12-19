package ru.levelup.homework6;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class KeypadReader {
    private int value;
    private String line;

    public int getNumber() {
        try (Scanner scanner = new Scanner(System.in)) {
            line = scanner.nextLine();
            exitRequestCheck();
            value = Integer.parseInt(line);
        } catch (Exception ex) {
            System.out.println("Не допустимый символ. Повторим.");
            getNumber();
        }
        return value;
    }

    public String getString() {
        try (Scanner scanner = new Scanner(System.in)) {
            line = scanner.nextLine();
            exitRequestCheck();

            if (!line.matches("[а-яА-Яa-zA-Z]+")) {
                throw new NumberFormatException();
            }

        } catch (NumberFormatException ex) {
            System.out.println("Не допустимый символ. Повторим.");
            getString();
        }
        return line;
    }

    private void exitRequestCheck() {
        if (line.equals("exit") || line.equals("quit") || line.equals("0")) {
            System.exit(1);
        }
    }

}
