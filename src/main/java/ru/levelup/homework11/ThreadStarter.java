package ru.levelup.homework11;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static ru.levelup.homework11.PrintInConsole.printFile;

public class ThreadStarter {

    static ArrayList<Thread> threads = new ArrayList<>();

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        IntStream.range(0, 3).mapToObj(num -> new Logger(String.format("Привет из %s потока", num), LogLevel.TRACE)).
                forEach(logger -> {
                    threads.add(logger);
                    logger.start();
                });

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (Thread thread : threads) {
            thread.interrupt();
        }

        printFile();

        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime);
    }
}
