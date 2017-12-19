package com.courses.spalah.variables;

import java.util.ArrayList;
import java.util.List;

import com.courses.spalah.util.RandomUtils;
import com.courses.spalah.util.Pair;

/**
 * @author Ievgen Tararaka
 */
public class StringTestVariables {
    public static final List<Pair<Integer, String>> COUNT_EVEN = new ArrayList<>();
    public static final List<Pair<String, Pair<String, String>>> REMOVE_SYMBOL = new ArrayList<>();

    static {
        COUNT_EVEN.add(new Pair<>(3, "1_4_8_11_22"));
        COUNT_EVEN.add(new Pair<>(3, "1_4_8_11_22"));
        COUNT_EVEN.add(new Pair<>(3, "1_4_8_11_22"));
        COUNT_EVEN.add(new Pair<>(3, "1_4_8_11_22"));

        REMOVE_SYMBOL.add(new Pair<>("aaa", new Pair<>("x", "aaa")));
        REMOVE_SYMBOL.add(new Pair<>("axa", new Pair<>("a", "aaxa")));
        REMOVE_SYMBOL.add(new Pair<>("cbc", new Pair<>("b", "cbc")));
        REMOVE_SYMBOL.add(new Pair<>("1x1x1", new Pair<>("1", "1x1x1")));
    }

    public static Object[] getAllRandom() {
        return new Object[]{
                RandomUtils.getRandomFrom(COUNT_EVEN),
                RandomUtils.getRandomFrom(REMOVE_SYMBOL)
        };
    }
}
