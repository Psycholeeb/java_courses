package com.courses.spalah;

import java.util.Arrays;

import com.courses.spalah.util.RandomUtils;
import com.courses.spalah.util.TestUtils;
import com.courses.spalah.util.ValueArrayPair;
import com.courses.spalah.variables.LoopTestVariables;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;

/**
 * @author Ievgen Tararaka
 */
@RunWith(Parameterized.class)
public class MinTest {
    private ValueArrayPair<Integer, Integer> testData;

    public MinTest(ValueArrayPair<Integer, Integer> testData) {
        this.testData = testData;
    }

    @Parameterized.Parameters(name = "{index}: метод min:{0}")
    public static Iterable<Object[]> data() {
        return Arrays.<Object[]>asList(new Object[]{RandomUtils.getRandomFrom(LoopTestVariables.MIN_TEST)});
    }

    @Test
    public void testMin() {
        int expected = testData.left;
        Integer[] arguments = testData.right;
        int result = HomeWorkLoops.min(ArrayUtils.toPrimitive(testData.right));
        assertTrue(TestUtils.buildMessage("min", Arrays.toString(arguments), String.valueOf(result), String.valueOf(expected)),
                expected == result);
    }
}
