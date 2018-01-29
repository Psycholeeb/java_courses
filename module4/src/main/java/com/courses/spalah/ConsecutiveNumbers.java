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

        if(verifySequence(string)){
            System.out.println("Последовательность чисел правильная!");
        } else
            System.out.println("Последовательность чисел не правильная!");
    }

    private static boolean verifySequence(String string) {
        int iterator = 0;

        if (string.charAt(0) != '1')
            return false;
        else {
            for (String number : string.split(",")) {
                if (Integer.parseInt(number) != iterator + 1) {
                    return false;
                }
                iterator++;
            }
        }
        return true;
    }
}
