package com.courses.spalah.util;

import java.util.List;
import java.util.Random;

/**
 * @author Ievgen Tararaka
 */
public class RandomUtils {
    private static final Random r = new Random();

    public static Object getRandomFrom(List<? extends Object> list) {
        int random = r.nextInt(list.size());
        return list.get(random);
    }
}
