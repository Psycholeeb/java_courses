package com.courses.spalah;

import java.util.Arrays;

class HomeWorkLoops {

    /**
     * Метод должен вернуть минимальное число
     * из заданного массива.
     * <p>Например:
     * вернуть число=3 при заданном массиве=[5, 4, 3, 4, 5]
     *
     * @param integers заданный массив типа int[]
     * @return минимальное число из массива
     */

    static int min(int[] integers) {
        int[] array = new int[integers.length];
        int tmp = 0;

        for (int i = 0; i < array.length; i++) {
            array[i] = integers[i];
            System.out.println("element[" + i + "] = " + array[i]);

            if (i == 0) {
                tmp = array[i];
            }
            if (array[i] < tmp) {
                tmp = array[i];
            }
        }

        System.out.println("Min number = " + tmp);

        return tmp;
    }

    /**
     * Метод должен вернуть максимальное число
     * из заданного массива.
     * <p>Например:
     * вернуть число=6.0 при заданном массиве=[5.1, 4.33, 3.0, 6.0, 5.999]
     *
     * @param doubles заданный массив типа double[]
     * @return максимальное число из массива
     */

    static double max(double[] doubles) {
        double[] array = new double[doubles.length];
        double tmp = 0;

        for (int i = 0; i < array.length; i++) {
            array[i] = doubles[i];
            System.out.println("element[" + i + "] = " + array[i]);

            if (i == 0) {
                tmp = array[i];
            }
            if (array[i] > tmp) {
                tmp = array[i];
            }
        }

        System.out.println("Max number = " + tmp);

        return tmp;
    }

    /**
     * Метод должен вернуть среднее арифмитическое число
     * из заданного массива.
     * <p>Например:
     * вернуть число=8.0 при заданном массиве=[1, 3, 8, 10, 25, 1]
     *
     * @param shorts заданный массив типа short[]
     * @return среднее арифмитическое число из массива
     */

    static float average(short[] shorts) {
        short[] array = new short[shorts.length];
        float tmp = 0;
        float average = 0;
        int i = 0;

        while (i != array.length) {
            array[i] = shorts[i];
            System.out.println("element[" + i + "] = " + array[i]);
            tmp += array[i];
            i++;
        }

        average = tmp / array.length;

        System.out.println("Average number = " + average);

        return average;
    }

    /**
     * Метод должен перевернуть массив.
     * <p>Например:
     * вернуть массив=[f, e, d, c, b, a] из заданного массива=[a, b, c, d, e, f]
     *
     * @param chars заданный массив типа char[]
     * @return перевернутый массив
     */

    static char[] reverse(char[] chars) {
        char[] array = new char[chars.length];
        char tmp = 0;
        int iterator = 0;
        int halfOfLenghtArray = 0;

        for (int i = 0; i < array.length; i++) {
            array[i] = chars[i];
            halfOfLenghtArray = array.length / 2;
        }

        System.out.println(Arrays.toString(array));

        do {
            tmp = array[iterator];

            array[iterator] = array[array.length - 1 - iterator];
            array[array.length - 1 - iterator] = tmp;
            iterator++;
        } while (iterator < halfOfLenghtArray);

        System.out.println(Arrays.toString(array));

        return array;
    }
}
