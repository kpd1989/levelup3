package ru.levelup.homework6;

import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class KeypadReader {

    public int getNumber() {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        try{
            number = scanner.nextInt();

        } catch (Exception ignore){
            System.out.println("Не допустимый символ. Повторим.");
            getNumber();
        }
        return number;
    }

    public String getString() {
        Scanner scanner = new Scanner(System.in);
        String line = null;
        try{
            line = scanner.nextLine();
            if (!line.matches("[а-яА-Яa-zA-Z]+")) {
                throw new NumberFormatException();
            }
        } catch (Exception ignore){
            System.out.println("Не допустимый символ. Повторим.");
            getString();
        }
        return line;
    }
}
