package sourceLib;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for operators.
 */
public class OperatorTest {
    @Test
    public void testGivesAdditionOfTwoNumbersWhenOperatorIsPlus() throws Exception {
        Operator operator = new Operator();
        double expected = 3;

        double actual = operator.calculateResult("+", 1, 2);

        Assert.assertEquals(expected, actual, 1);
    }

    @Test
    public void testGivesSubstractionOfTwoNumbersWhenOperatorIsMinus() throws Exception {
        Operator operator = new Operator();
        double expected = -10;

        double actual = operator.calculateResult("-", 10, 20);

        Assert.assertEquals(expected, actual, 1);
    }

    @Test
    public void testGivesMultiplicationOfTwoNumbersWhenOperatorIsInto() throws Exception {
        Operator operator = new Operator();
        double expected = 10;

        double actual = operator.calculateResult("*", 5, 2);

        Assert.assertEquals(expected, actual, 1);
    }

    @Test
    public void testGivesDivisionOfTwoNumbersWhenOperatorIsDivide() throws Exception {
        Operator operator = new Operator();
        double expected = 4;

        double actual = operator.calculateResult("/", 20, 5);

        Assert.assertEquals(expected, actual, 1);
    }

    @Test
    public void testGivesPowerOfTwoNumbersWhenOperatorIsCarrat() throws Exception {
        Operator operator = new Operator();
        double expected = 16;

        double actual = operator.calculateResult("^", 4, 2);

        Assert.assertEquals(expected, actual, 1);
    }
}
