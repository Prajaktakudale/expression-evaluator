package main;

import junit.framework.Assert;
import org.junit.Test;
import sourceLib.Evaluator;

public class evaluatorTest {
    @Test
    public void testWillGives10IfExpression5plus5() throws Exception {
        String actual;
        String expected = "10";

        Evaluator evaluate = new Evaluator();
        actual = evaluate.expressionEvaluator("5 + 5");

        Assert.assertEquals(actual, expected);
    }
    @Test
    public void testWillGives20IfExpression10plus10() throws Exception {
        String actual;
        String expected = "20";

        Evaluator evaluate = new Evaluator();
        actual = evaluate.expressionEvaluator("10 + 10");

        Assert.assertEquals(actual, expected);
    }
}
