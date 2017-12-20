package com.courses.spalah;

import java.lang.reflect.Array;
import java.util.Scanner;

/**
 * @author Ievgen Tararaka
 */
public class PrintMatrix {
    /**
     * Написать программу, печатает двумерный массив заданного размера
     * квадратом и 4-мя треугольниками.
     *
     * Входные параметры программы:
     * 1. Размер массива
     * 2. Символ для печати
     *
     * Пример
     * Размер массива - 5
     * Символ для печати - #
     * <p>
     * # # # # #
     * # # # # #
     * # # # # #
     * # # # # #
     * # # # # #
     * <p>
     * #
     * # #
     * # # #
     * # # # #
     * # # # # #
     * <p>
     * # # # # #
     * # # # #
     * # # #
     * # #
     * #
     * <p>
     *         #
     *       # #
     *     # # #
     *   # # # #
     * # # # # #
     * <p>
     * # # # # #
     *   # # # #
     *     # # #
     *       # #
     *         #
     * @param args - размер массива
     */

    private static int arraySize = 0;
    private static int numberOfPrint = 0;
    private static int counter;

    public static void main(String[] args) {
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);

        String symbol;

        System.out.print("Введите размер массива: ");
        arraySize = scannerInt.nextInt();
        System.out.print("Введите символ для печати: ");
        symbol = scannerString.nextLine();

        String[][] array = new String[arraySize][arraySize];

        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                array[i][j] = symbol;
            }
        }

        System.out.println("Выберете способ печати массива: ");
        System.out.println("1. Квадрат");
        System.out.println("2. Спуск вниз");
        System.out.println("3. Спуск вниз (зеркально)");
        System.out.println("4. Подьем вверх");
        System.out.println("5. Подьем вверх (зеркально)");
        numberOfPrint = scannerInt.nextInt();

        switch (numberOfPrint) {
            case 1:
                squarePrint(array);
                break;
            case 2:
                downPrint(array);
                break;
            case 3:
                downPrintMirror(array);
                break;
            case 4:
                upPrint(array);
                break;
            case 5:
                upPrintMirror(array);
                break;
            default:
                System.out.println("Нет такого пункта печати!");
                break;
        }
        //System.out.println(arraySize + symbol);
    }

    private static void squarePrint(String[][] arrayForPrint) {
        System.out.println("Выбран способ печати квадрат!");
        counter = 0;

        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                System.out.print(arrayForPrint[i][j]);
            }
            System.out.println();
        }
    }

    private static void downPrint(String[][] arrayForPrint) {
        System.out.println("Выбран способ печати спуск вниз!");
        counter = 1;

        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < counter; j++) {
                System.out.print(arrayForPrint[i][j]);
            }
            counter++;
            System.out.println();
        }
    }

    private static void downPrintMirror(String[][] arrayForPrint) {
        System.out.println("Выбран способ печати спуск вниз (зеркальный)!");
        counter = 0;

        for (int i = 0; i < arraySize; i++) {
            for (int j = arraySize - 1; j >= counter; j--) {
                System.out.print(arrayForPrint[i][j]);
            }
            counter++;
            System.out.println();
        }
    }

    private static void upPrint(String[][] arrayForPrint) {
        System.out.println("Выбран способ печати подьем вверх!");
        counter = 1;

        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                if (j + counter == arraySize)
                    System.out.print(arrayForPrint[i][j]);
                if (j + counter > arraySize)
                    System.out.print(arrayForPrint[i][j]);
                if (j + counter < arraySize)
                    System.out.print(" ");
            }
            counter++;
            System.out.println();
        }
    }

    private static void upPrintMirror(String[][] arrayForPrint) {
        System.out.println("Выбран способ печати подьем вверх (зеркально)!");
        counter = arraySize;

        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                if (j + counter == arraySize)
                    System.out.print(arrayForPrint[i][j]);
                if (j + counter > arraySize)
                    System.out.print(arrayForPrint[i][j]);
                if (j + counter < arraySize)
                    System.out.print(" ");
            }
            counter--;
            System.out.println();
        }
    }
}
