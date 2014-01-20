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
}
