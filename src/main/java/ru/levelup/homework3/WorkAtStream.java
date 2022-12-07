package ru.levelup.homework3;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class WorkAtStream {

    public static void main(String[] args) {

        List<Integer> integerList = new Random().ints(1000, 0, Integer.MAX_VALUE)
                .boxed()
                .toList();
        System.out.println(integerList);
        printMax(integerList);
        printMin(integerList);
        printAverage(integerList);
        printSum(integerList);
        convertToMap(integerList);
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
//        System.out.println("Среднее: " + intList.stream()
//                .mapToInt(Integer::intValue)
//                .average().getAsDouble());
    }

    private static void printSum(List<Integer> intList) {
        System.out.println("Сумма нечетных эл-ов = " + IntStream.range(0, intList.size())
                .filter(x -> x % 2 == 0)
                .mapToDouble(intList::get)
                .sum());
    }

    private static void convertToMap(List<Integer> words) {
        Map<Integer, Integer> result = new HashMap<>(words.size());
        for (Integer word: words) {
            int sum=0;
            int x=word;
            while(x != 0){
                sum += (x % 10);
                x/=10;
            }
            result.put(word, sum);

        }
        System.out.println(result);
    }
}
