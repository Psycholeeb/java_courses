package com.courses.spalah;

import java.util.Scanner;

/**
 * @author Ievgen Tararaka
 */
public class ConsecutiveNumbers {
    /**
     * Написать программу, которая отвечает на вопрос:
     * "Содержит ли введенная строка правильную последовательность цифр?"
     *
     * Входные параметры программы:
     * 1. Строка с числами (только целые числа, которые не больше, чем int)
     * 2. Разделительный символ для этой строки. Разделительный символ в строке может быть любой, пустой в том числе.
     *
     * Например:
     * Строка - 1*2*3*6*7
     * Символ - *
     * Ответ - false
     *
     * @param args - аргументы коммандной строки
     */
    public static void main(String[] args) {
        System.out.print("Введите строку из любых чисел, разделяя их запятой: ");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        check(string);
    }

    private static void check(String string) {
        int[] arrayOfChar = new int[string.length()];
        int iterator = 0;
        int error = 0;

        for (String tmp : string.split(",")) {
            arrayOfChar[iterator] = Integer.parseInt(tmp);
            if (arrayOfChar[iterator] != iterator + 1) {
                error++;
            }
            iterator++;
        }

        switch (error) {
            case 0:
                System.out.println("Последовательность чисел правильная!");
                break;
            default:
                System.out.println("Последовательность чисел не правильная!");
        }
    }
}
