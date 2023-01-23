package ru.levelup.homework11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PrintInConsole {

    public static void printFile() {
        String filePath = "results.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.lines().forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
