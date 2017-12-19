package com.courses.spalah.util;

import java.util.Arrays;

/**
 * @author Ievgen Tararaka
 */
public class ValueArrayPair<L, R> {
    public final L left;
    public final R[] right;

    public ValueArrayPair(L left, R[] right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        String rightString = Arrays.toString(right);
        return "{" +
                "ожидаемый результат=" + left +
                ", входные данные=" + rightString +
                '}';
    }
}
