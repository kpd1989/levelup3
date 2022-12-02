package ru.levelup.homework2.version2.check;

public class CheckInputText {
    public static void stupidStupidityTestInput(String[] words) {
        try {
            if (words[0].isBlank()) {
                System.out.println("Вы ввели пустое поле :(");
                System.exit(1);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Увы. Слова отсутствуют :(");
        }
    }
}
