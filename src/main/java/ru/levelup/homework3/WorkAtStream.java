package ru.levelup.homework3;

import java.util.*;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class WorkAtStream {

    public static void main(String[] args) {

        List<Integer> integerList = new Random().ints(1000, 0, 1_000_000)
                .boxed()
                .toList();
        System.out.println("Полный список " + integerList);
        System.out.println("-------------------");

        printMax(integerList);
        System.out.println("-------------------");

        printMin(integerList);
        System.out.println("-------------------");

        printAverage(integerList);
        System.out.println("-------------------");

        printSum(integerList);
        System.out.println("-------------------");

        System.out.println("число = сумма элементов числа \n"
                + convertToMap(integerList));
    }

    private static void printMax(List<Integer> intList) {
        System.out.println("Максимум: " + intList.stream()
                .max(Comparator
                        .comparingInt(Integer::intValue))
                .or(() -> Optional.of(-1))
                .get());
    }

    private static void printMin(List<Integer> intList) {
        System.out.println("Минимум: " + intList.stream()
                .min(Comparator
                        .comparingInt(Integer::intValue))
                .or(() -> Optional.of(-1))
                .get());
    }

    private static void printAverage(List<Integer> intList) {
        System.out.println("Среднее: " + intList.stream()
                .collect(Collectors.averagingInt(Integer::intValue)));
    }

    private static void printSum(List<Integer> intList) {
        System.out.println("Сумма нечетных эл-ов = " + IntStream.range(0, intList.size())
                .filter(x -> x % 2 == 0)
                .mapToDouble(intList::get)
                .sum());
    }

    private static Map<Integer, Integer> convertToMap(List<Integer> intList) {
        return intList.stream()
                .collect(Collectors
                        .toMap(Function.identity(),
                                value -> String.valueOf(value)
                                        .chars()
                                        .map(Character::getNumericValue)
                                        .sum()
                                , (a, b) -> a));
    }
}
