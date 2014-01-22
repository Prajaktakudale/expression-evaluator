package main;

import junit.framework.Assert;
import org.junit.Test;
import sourceLib.Evaluator;

public class evaluatorTest {
    @Test
    public void testWillGives10IfExpression5plus5() throws Exception {
        String actual;
        String expected = "10.0";

        Evaluator evaluate = new Evaluator();
        actual = evaluate.expressionEvaluator("5 + 5");

        Assert.assertEquals(actual, expected);
    }
    @Test
    public void testWillGives20IfExpression10plus10() throws Exception {
        String actual;
        String expected = "20.0";

        Evaluator evaluate = new Evaluator();
        actual = evaluate.expressionEvaluator("10 + 10");

        Assert.assertEquals(actual, expected);
    }
    @Test
    public void testWillGives0IfExpression10minus10() throws Exception {
        String actual;
        String expected = "0.0";

        Evaluator evaluate = new Evaluator();
        actual = evaluate.expressionEvaluator("10 - 10");

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testWillGives20IfExpression5into4() throws Exception {
        String actual;
        String expected = "20.0";

        Evaluator evaluate = new Evaluator();
        actual = evaluate.expressionEvaluator("5 * 4");

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testWillGives3IfExpression15divided5() throws Exception {
        String actual;
        String expected = "3.0";

        Evaluator evaluate = new Evaluator();
        actual = evaluate.expressionEvaluator("15 / 5");

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testWillGives8IfExpression2topow3() throws Exception {
        String actual;
        String expected = "8.0";

        Evaluator evaluate = new Evaluator();
        actual = evaluate.expressionEvaluator("2 ^ 3");

        Assert.assertEquals(actual, expected);
    }
}
