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
public class AverageTest {
    private static final float PRECISION = 0.001F;

    private ValueArrayPair<Float, Short> testData;

    public AverageTest(ValueArrayPair<Float, Short> testData) {
        this.testData = testData;
    }

    @Parameterized.Parameters(name = "{index}: метод average:{0}")
    public static Iterable<Object[]> data() {
        return Arrays.<Object[]>asList(new Object[]{RandomUtils.getRandomFrom(LoopTestVariables.AVERAGE_TEST)});
    }

    @Test
    public void testAverage() {
        float expected = testData.left;
        Short[] arguments = testData.right;
        double result = HomeWorkLoops.average(ArrayUtils.toPrimitive(testData.right));
        assertTrue(TestUtils.buildMessage("average", Arrays.toString(arguments), String.valueOf(result), String.valueOf(expected)),
                Math.abs(result - expected) < PRECISION);
    }
}
