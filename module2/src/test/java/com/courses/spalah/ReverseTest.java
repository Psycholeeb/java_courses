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
public class ReverseTest {

    private ValueArrayPair<char[], Character> testData;

    public ReverseTest(ValueArrayPair<char[], Character> testData) {
        this.testData = testData;
    }

    @Parameterized.Parameters(name = "{index}: метод reverse:{0}")
    public static Iterable<Object[]> data() {
        return Arrays.<Object[]>asList(new Object[]{RandomUtils.getRandomFrom(LoopTestVariables.REVERSE_TEST)});
    }

    @Test
    public void testReverse() {
        char[] expected = testData.left;
        Character[] arguments = testData.right;
        char[] result = HomeWorkLoops.reverse(ArrayUtils.toPrimitive(testData.right));
        assertTrue(TestUtils.buildMessage("reverse", Arrays.toString(arguments), Arrays.toString(result), Arrays.toString(expected)),
                Arrays.equals(expected, result));
    }
}
