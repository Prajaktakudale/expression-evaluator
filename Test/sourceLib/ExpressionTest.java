package sourceLib;

import junit.framework.Assert;
import org.junit.Test;

public class ExpressionTest {
    @Test
    public void testWillGives20IfExpression10plus10() throws Exception {
        Expression actual = new InputParser().parseInput("5 + 5");

        Assert.assertEquals(10.0, actual.getValue());
    }

    @Test
    public void testWillGives0IfExpression10minus10() throws Exception {
        String expression = "10 - 10";
        double expected = 0.0;

        Expression actual = new InputParser().parseInput(expression);

        Assert.assertEquals(expected, actual.getValue());
    }

    @Test
    public void testWillGives20IfExpression5into4() throws Exception {
        String expression = "5 * 4";
        double expected = 20.0;

        Expression actual = new InputParser().parseInput(expression);

        Assert.assertEquals(expected, actual.getValue());
    }

    @Test
    public void testWillGives3IfExpression15divided5() throws Exception {
        String expression = "15 / 5";
        double expected = 3.0;

        Expression actual = new InputParser().parseInput(expression);

        Assert.assertEquals(expected, actual.getValue());
    }

    @Test
    public void testWillGives8IfExpression2topow3() throws Exception {
        String expression = "2 ^ 3";
        double expected = 8.0;

        Expression actual = new InputParser().parseInput(expression);

        Assert.assertEquals(expected, actual.getValue());
    }

    @Test
    public void testWillGivesExpression() throws Exception {
        String expression = "2 + 3 *2 + 8";

        Expression actual = new InputParser().parseInput(expression);

        Assert.assertEquals(18.0, actual.getValue());
    }

    @Test
    public void testWillGives18AfterEvalutionOfExpression() throws Exception {
        String expression = "2 + 3 * 2 + 8";
        double expected = 18.0;

        Expression actual = new InputParser().parseInput(expression);

        Assert.assertEquals(expected, actual.getValue());
    }

    @Test
    public void testWillGives3point0ForExpressionWhichHasOneBracket() throws Exception {
        String expression = "(2 + 1)";
        double expected = 3.0;

        Expression actual = new InputParser().parseInput(expression);

        Assert.assertEquals(expected, actual.getValue());
    }

    @Test
    public void testWillgive50ForExpressionWhichHasBracket() throws Exception {
        String expression = "2 + 3 * ( 2 + 8 )";
        double expected = 50.0;

        Expression actual = new InputParser().parseInput(expression);

        Assert.assertEquals(expected, actual.getValue());
    }

    @Test
    public void testWillgive52ForExpressonWhichHasMultipleBrackets() throws Exception {
        String expression = "2 + 3 * ( 2 + 8 ) + (1 + 1)";
        double expected = 52.0;

        Expression actual = new InputParser().parseInput(expression);

        Assert.assertEquals(expected, actual.getValue());
    }

    @Test
    public void testWillgive6ForExpressonWhichHasNestedBrackets() throws Exception {
        String expression = "2 + ( 1 + ( 2 + 1))";
        double expected = 6.0;

        Expression actual = new InputParser().parseInput(expression);

        Assert.assertEquals(expected, actual.getValue());
    }

    @Test
    public void testWillgiveminus14point0ForExpressonWhichHasNestedBrackets() throws Exception {
        String expression = "2 + ( (1 + 1)-(6 * ( 2 + 1)))";
        double expected = -14.0;

        Expression actual = new InputParser().parseInput(expression);

        Assert.assertEquals(expected, actual.getValue());
    }

    @Test
    public void testWillGives3point0AfterEvalutionOfFloatExpression() throws Exception {
        String expression = "2.0 + 1.0";
        double expected = 3.0;

        Expression actual = new InputParser().parseInput(expression);

        Assert.assertEquals(expected, actual.getValue());
    }

    @Test
    public void testWillGives1AfterEvalutionOfFloatExpression() throws Exception {
        String expression = "(2.0 + 1.0) + 4.0";
        double expected = 7.0;

        Expression actual = new InputParser().parseInput(expression);

        Assert.assertEquals(expected, actual.getValue());
    }

    @Test
    public void testWillGives4point0AfterEvalutionOfExpressionWhichDontHaveSpace() throws Exception {
        String expression = "2+2";
        double expected = 4.0;

        Expression actual = new InputParser().parseInput(expression);

        Assert.assertEquals(expected, actual.getValue());
    }


    @Test
    public void testWillGives27point0AfterEvalutionOfExpressionWhichDontHaveSpace() throws Exception {
        String expression = "2.0+1*((9.0*2)/2.0)";
        double expected = 27.0;

        Expression actual = new InputParser().parseInput(expression);

        Assert.assertEquals(expected, actual.getValue());
    }

    @Test
    public void testWillGivespoint0AfterEvalutionOfExpressionWhichDontHaveSpace() throws Exception {
        String expression = "(-1)";
        double expected = -1.0;

        Expression actual = new InputParser().parseInput(expression);

        Assert.assertEquals(expected, actual.getValue());
    }

    @Test
    public void testWillGives1AfterEvalutionOfExpressionWhichDontHaveSpace() throws Exception {
        String expression = "(1)";
        double expected = 1;

        Expression actual = new InputParser().parseInput(expression);

        Assert.assertEquals(expected, actual.getValue());
    }

    @Test
    public void testWillGivesminus1point0AfterEvalutionOfExpression() throws Exception {
        String expression = "-7/7";
        double expected = -1.0;

        Expression actual = new InputParser().parseInput(expression);

        Assert.assertEquals(expected, actual.getValue());
    }

    @Test
    public void testWillGivesminus20point0AfterEvalutionOfExpression() throws Exception {
        String expression = "23+(-3)";
        double expected = 20.0;

        Expression actual = new InputParser().parseInput(expression);

        Assert.assertEquals(expected, actual.getValue());
    }

    @Test
    public void testWillGives18point0AfterEvalutionOfExpression() throws Exception {
        String expression = "9 - -9";
        double expected = 18.0;

        Expression actual = new InputParser().parseInput(expression);

        Assert.assertEquals(expected, actual.getValue());
    }

    @Test
    public void testWillGivesminus4point0AfterEvalutionOfExpression() throws Exception {
        String expression = "-2-2";
        double expected = -4.0;

        Expression actual = new InputParser().parseInput(expression);

        Assert.assertEquals(expected, actual.getValue());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testWillGiveExceptionAfterEvalutionOfExpression() throws Exception {
        String expression = "22*";

        new InputParser().parseInput(expression);

    }

    @Test
    public void testWillGives8point0AfterEvalutionOfExpression() throws Exception {
        String expression = "        8     +     0";
        double expected = 8.0;

        Expression actual = new InputParser().parseInput(expression);

        Assert.assertEquals(expected, actual.getValue());
    }

    @Test
    public void testWillGivesminus1pointAfterEvalutionOfExpression() throws Exception {
        String expression = "2 ^ (-3)";
        double expected = 0.125;

        Expression actual = new InputParser().parseInput(expression);

        Assert.assertEquals(expected, actual.getValue());
    }

    @Test(expected = NumberFormatException.class)
    public void testWillGivesExceptionAfterEvalutionOfExpression() throws Exception {
        String expression = "a*1";

        new InputParser().parseInput(expression);

    }

    @Test
    public void testWillGivesminus0pointAfterEvalutionOfExpression() throws Exception {
        String expression = "1.25 -- 0.25";
        double expected = 1.5;

        Expression actual = new InputParser().parseInput(expression);

        Assert.assertEquals(expected, actual.getValue());
    }

}