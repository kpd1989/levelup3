package ru.levelup.homework2.version1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FrequencyAnalysis {
    static Map<String, Integer> mapWords = new LinkedHashMap<>();

    public static void main(String[] args) {

        createArrayWords();

        sortWordsInArrayList();
    }

    private static void createArrayWords() {
        String line = readFromConsole();

        String[] words = line.toLowerCase().split("(?U)[\\W]+");

        stupidStupidityTestInput(words);

        Arrays.stream(words).forEach(
                word -> mapWords.put(word, mapWords.containsKey(word) ? mapWords.get(word) + 1 : 1));
    }

    private static String readFromConsole() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void sortWordsInArrayList() {
        ArrayList<String> listWords = new ArrayList<>(mapWords.keySet());

        listWords.sort((a, b) ->
                -Integer.compare(mapWords.get(a), mapWords.get(b)));

        printOnConsole(listWords);
    }

    private static void printOnConsole(ArrayList<String> allWords) {
        allWords.stream().map(word -> word + " -" + mapWords.get(word) + " раз(а)").forEach(System.out::println);
    }

    private static void stupidStupidityTestInput(String[] words) {
        try {if (words[0].isBlank()) {
            System.out.println("Вы ввели пустое поле :(");
            System.exit (1);
        }} catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Увы. Слова отсутствуют :(");
        }
    }
}