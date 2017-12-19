package com.courses.spalah;

import java.util.Arrays;

import com.courses.spalah.util.Pair;
import com.courses.spalah.util.RandomUtils;
import com.courses.spalah.util.TestUtils;
import com.courses.spalah.variables.StringTestVariables;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * @author Ievgen Tararaka
 */
@RunWith(Parameterized.class)
public class CountStringTest {
    private Pair<Integer, String> countEvenEntry;

    public CountStringTest(Pair<Integer, String> countEvenEntry) {
        this.countEvenEntry = countEvenEntry;
    }

    @Parameterized.Parameters(name = "{index}: метод countEven:{0}")
    public static Iterable<Object[]> data() {
        return Arrays.<Object[]>asList(new Object[]{RandomUtils.getRandomFrom(StringTestVariables.COUNT_EVEN)});
    }

    @Test
    public void testCountEven() {
        int expected = countEvenEntry.left;
        int result = HomeWorkStrings.countEvenInString(countEvenEntry.right);
        String arguments = countEvenEntry.right;
        Assert.assertTrue(TestUtils.buildMessage("countEven", arguments, String.valueOf(result), String.valueOf(expected)),
                HomeWorkStrings.countEvenInString(countEvenEntry.right) == countEvenEntry.left);
    }
}
