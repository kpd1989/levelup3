package ru.levelup.homework5;

import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class KeypadReader {
   private final Scanner scanner = new Scanner(System.in);

    public int getNumber() {
        int value=0;
        try{
            value = scanner.nextInt();
        } catch (InputMismatchException ex){
            System.out.println("Фибоначчи - это про цифры. Досвидания!");
        }

        if( value==0 ) System.exit(1);
        return value;
    }
}
