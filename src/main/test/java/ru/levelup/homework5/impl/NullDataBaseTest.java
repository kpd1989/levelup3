package ru.levelup.homework5.impl;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class NullDataBaseTest {

    public NullDataBase nullDataBase = new NullDataBase();

    @Test
    public void testGetElement() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        nullDataBase.getElement(7);

        String allWrittenLines = outputStreamCaptor.toString();
        assertTrue(allWrittenLines.contains("7-й элемент последовательности =11"));

        /*assertEquals("7-й элемент последовательности =11\n" +
                     "-----------------------\n",
                outputStreamCaptor.toString());*/
    }
}