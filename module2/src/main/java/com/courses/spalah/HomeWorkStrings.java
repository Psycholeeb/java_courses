package com.courses.spalah;

/**
 * Модифицируйте этот класс(файл)
 *
 * @author Ievgen Tararaka
 */

public class HomeWorkStrings {
    /**
     * Метод должен вернуть количество четных чисел в строке.
     * <p>Например:
     * дана строка - 1_4_8_11_22, ответ - 3
     *
     * @param s строка типа число1_число2_число3_число4
     * @return количество четных числе в строке
     */
    static int countEvenInString(String s) {
        int counterOfNumber = 0;

        for (String tmp : s.split("_")) {
            if (Integer.parseInt(tmp) % 2 == 0)
                counterOfNumber++;
        }
        System.out.println(counterOfNumber);

        return counterOfNumber;
    }

    /**
     * Метод должен удалить указанный символ из строки (кроме случая, если
     * символ находится на первой, последней или срединной позиции)
     * <p>Например:
     * данна строка - xabxxxx, символ - x, ответ - xabx
     *
     * @param symbol символ который необходимо удалить
     * @param s      исходная строка
     * @return результирующая строка
     */

    static String removeSymbolFromString(String symbol, String s) {
        StringBuilder clearString = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == symbol.charAt(0)) {
                if ((i == 0) || (i == s.length() / 2) || (i == s.length() - 1)) {
                    clearString.append(s.charAt(i));
                }
            } else {
                clearString.append(s.charAt(i));
            }
        }
        return clearString.toString();
    }
}
