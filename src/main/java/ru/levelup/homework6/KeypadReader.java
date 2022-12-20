package ru.levelup.homework6;

import ru.levelup.homework6.model.City;

import java.util.Scanner;

public class KeypadReader {

    public static City getCity(){
        System.out.println("Введите код города");
        int id = getNumber();
        System.out.println("Название города на русском");
        String ruName = getString();
        System.out.println("Название города на английском");
        String engName = getString();
        System.out.println("Население");
        int population = getNumber();
        System.out.println("код региона");
        int regionId = getNumber();

        return new City(id,ruName, engName, population, regionId);
    }

    public static int getNumber() {
        Scanner scanner = new Scanner(System.in);
        int val = 0;
        try{
            val = scanner.nextInt();
    } catch (Exception ignore){
            System.out.println("Не допустимый символ. Повторим.");
getNumber();
    }
        return val;
    }

    public static String getString() {
        Scanner scanner = new Scanner(System.in);
        String val = null;
        try{
           val = scanner.nextLine();
            if (!val.matches("[а-яА-Яa-zA-Z]+")) {
                throw new NumberFormatException();
            }
       } catch (Exception ignore){
            System.out.println("Не допустимый символ. Повторим.");
getString();
       }
        return val;
    }
}
