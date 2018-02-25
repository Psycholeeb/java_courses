package com.courses.spalah.homework;

import java.util.Arrays;

public class RubberIntArray {
    private static int[] ints = new int[10];
    private static int size = 0;

    public static void main(String args[]) {

        //написал для удобства проверки
        for (int i = 0; i < 11; i++) {
            add(i);
        }

        for (int i = 0; i < ints.length; i++) {
            System.out.print(" [" + getByIndex(i) + "]");
        }
    }

    /**
     * Добавляет элемент в массив. Если размер массива не позволяет добавить элемент - его необходимо увеличить на 5.
     *
     * @param i элемент, который необходимо добавить в массив
     */

    private static void add(int i) {
        if (size == ints.length) {
            ints = Arrays.copyOf(ints, ints.length + 5);
        }

        ints[size] = i;
        size++;
    }

    private static int getByIndex(int index) {
        return ints[index];
    }
}
