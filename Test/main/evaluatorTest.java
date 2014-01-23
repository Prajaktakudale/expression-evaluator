package main;

import junit.framework.Assert;
import org.junit.Test;
import sourceLib.Evaluator;

public class evaluatorTest {
    @Test
    public void testWillGives20IfExpression10plus10() throws Exception {
        String expression = "5 + 5";
        int expected = 10;

        Evaluator evaluator = new Evaluator(expression);
        int actual = evaluator.getResult();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testWillGives0IfExpression10minus10() throws Exception {
        String expression = "10 - 10";
        int expected = 0;

        Evaluator evaluator = new Evaluator(expression);
        int actual = evaluator.getResult();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testWillGives20IfExpression5into4() throws Exception {
        String expression = "5 * 4";
        int expected = 20;

        Evaluator evaluator = new Evaluator(expression);
        int actual = evaluator.getResult();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testWillGives3IfExpression15divided5() throws Exception {
        String expression = "15 / 5";
        int expected = 3;

        Evaluator evaluator = new Evaluator(expression);
        int actual = evaluator.getResult();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testWillGives8IfExpression2topow3() throws Exception {
        String expression = "2 ^ 3";
        int expected = 8;

        Evaluator evaluator = new Evaluator(expression);
        int actual = evaluator.getResult();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testWillGivesExpression() throws Exception {
        String expression = "2 + 3 *2 + 8";

        Evaluator evaluator = new Evaluator(expression);
        String actual = evaluator.getExpression();

        Assert.assertEquals(actual,expression);
    }

    @Test
    public void testWillGives18AfterEvalutionOfExpression() throws Exception {
        String expression = "2 + 3 * 2 + 8";
        int expected = 18;

        Evaluator evaluator = new Evaluator(expression);
        int actual = evaluator.getResult();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testWillgive50ForExpressionWhichHasBracket() throws Exception {
        String expression = "2 + 3 * ( 2 + 8 )";
        int expected = 50;

        Evaluator evaluator = new Evaluator(expression);
        int actual = evaluator.getResult();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testWillgive52ForExpressonWhichHasMultipleBrackets() throws Exception {
        String expression = "2 + 3 * ( 2 + 8 ) + (1 + 1)";
        int expected = 52;

        Evaluator evaluator = new Evaluator(expression);
        int actual = evaluator.getResult();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testWillgive6ForExpressonWhichHasNestedBrackets() throws Exception {
        String expression = "2 + ( 1 + ( 2 + 1))";
        int expected = 6;

        Evaluator evaluator = new Evaluator(expression);
        int actual = evaluator.getResult();

        Assert.assertEquals(actual, expected);
    }

}