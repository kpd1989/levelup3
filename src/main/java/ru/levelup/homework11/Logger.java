package ru.levelup.homework11;

import lombok.Data;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.concurrent.TimeUnit;


@Data
public class Logger extends Thread {

    private String message;
    private LogLevel logLevel;
    static final FileWriter writer;

    static {
        try {
            writer = new FileWriter("results.txt", StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Logger(String message, LogLevel logLevel) {
        this.message = message;
        this.logLevel = logLevel;
    }


    @Override
    public void run() {
        Random random = new Random();
        long lagTime = random.nextInt(1, 5);

        while (!Thread.currentThread().isInterrupted()) {

            String textToWrite = getText();
            try {
                synchronized (writer) {
                    writer.write(textToWrite);
                    writer.flush();
                }
                TimeUnit.SECONDS.sleep(lagTime);

            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException ignore) {
                interrupt();
            }
        }
    }

    private String getText() {
        return String.format("< %s >< %s >< %s >< %s >\n", new CurrentTime().getTime(), getName(), getState(), getMessage());
    }
}
