package com.courses.spalah;

import java.util.Arrays;

import com.courses.spalah.util.RandomUtils;
import com.courses.spalah.util.TestUtils;
import com.courses.spalah.util.Pair;
import com.courses.spalah.variables.StringTestVariables;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * @author Ievgen Tararaka
 */
@RunWith(Parameterized.class)
public class RemoveSymbolTest {
    private Pair<String, Pair<String, String>> removeSymbolFromStringEntry;

    public RemoveSymbolTest(Pair<String, Pair<String, String>> removeSymbolFromStringEntry) {
        this.removeSymbolFromStringEntry = removeSymbolFromStringEntry;
    }

    @Parameterized.Parameters(name = "{index}: метод removeSymbolFromString:{0}")
    public static Iterable<Object[]> data() {
        return Arrays.<Object[]>asList(new Object[]{RandomUtils.getRandomFrom(StringTestVariables.REMOVE_SYMBOL)});
    }

    @Test
    public void testRemoveSymbolFromString() {
        Pair<String, String> arguments = removeSymbolFromStringEntry.right;
        String expected = removeSymbolFromStringEntry.left;
        String result = HomeWorkStrings.removeSymbolFromString(arguments.left, arguments.right);
        Assert.assertTrue(TestUtils.buildMessage("removeSymbolFromString", arguments.toArgumentsString(), result, expected),
                expected.equals(result));
    }
}
