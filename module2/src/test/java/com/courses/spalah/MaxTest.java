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
public class MaxTest {
    private ValueArrayPair<Double, Double> testData;

    public MaxTest(ValueArrayPair<Double, Double> testData) {
        this.testData = testData;
    }

    @Parameterized.Parameters(name = "{index}: метод max:{0}")
    public static Iterable<Object[]> data() {
        return Arrays.<Object[]>asList(new Object[]{RandomUtils.getRandomFrom(LoopTestVariables.MAX_TEST)});
    }

    @Test
    public void testMax() {
        double expected = testData.left;
        Double[] arguments = testData.right;
        double result = HomeWorkLoops.max(ArrayUtils.toPrimitive(testData.right));
        assertTrue(TestUtils.buildMessage("max", Arrays.toString(arguments), String.valueOf(result), String.valueOf(expected)),
                expected == result);
    }
}
