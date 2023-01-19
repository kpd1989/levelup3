package ru.levelup.homework5;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;


public class KeypadReaderTest {


        static KeypadReader keypadReader = new KeypadReader();



    @Test
    public void testGetNumber() {
        ByteArrayInputStream inputValue = new ByteArrayInputStream("2".getBytes());
        keypadReader.setScanner(new Scanner(inputValue));

        keypadReader.getNumber();

        Assert.assertEquals(2, keypadReader.value);
    }

    @Test
    public void testException() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        ByteArrayInputStream inputValue = new ByteArrayInputStream("jghh\n1".getBytes());
        keypadReader.setScanner(new Scanner(inputValue));

        keypadReader.getNumber();

        assertEquals("Не допустимый символ. Повторим?\r\n",
                outputStreamCaptor.toString());

        assertEquals(1, keypadReader.value);




    }


}