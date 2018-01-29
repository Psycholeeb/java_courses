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
        int min = integers[0];

        for (int i = 0; i < integers.length; i++) {
            System.out.println("element[" + i + "] = " + integers[i]);

            if (integers[i] < min) {
                min = integers[i];
            }
        }

        System.out.println("Min number = " + min);

        return min;
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
        double max = 0;
        max = doubles[0];

        for (int i = 0; i < doubles.length; i++) {
            System.out.println("element[" + i + "] = " + doubles[i]);

            if (doubles[i] > max) {
                max = doubles[i];
            }
        }

        System.out.println("Max number = " + max);

        return max;
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
        float sum = 0;
        float average = 0;
        int i = 0;

        while (i != shorts.length) {
            System.out.println("element[" + i + "] = " + shorts[i]);
            sum += shorts[i];
            i++;
        }

        average = sum / shorts.length;

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
        char symbol = 0;
        int iterator = 0;
        int halfOfLenghtArray = 0;

        halfOfLenghtArray = chars.length / 2;

        System.out.println(Arrays.toString(chars));

        do {
            symbol = chars[iterator];

            chars[iterator] = chars[chars.length - 1 - iterator];
            chars[chars.length - 1 - iterator] = symbol;
            iterator++;
        } while (iterator < halfOfLenghtArray);

        System.out.println(Arrays.toString(chars));

        return chars;
    }
}
