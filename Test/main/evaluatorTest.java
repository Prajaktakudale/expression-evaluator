package main;

import org.junit.Test;
import sourceLib.Evaluator;

import static org.junit.Assert.assertEquals;

public class evaluatorTest {
    @Test
    public void testForReducingMoreThanOneSpeces() throws Exception {
        Evaluator eval = new Evaluator();

        int actual = eval.add(5, 2);
        int expected = 7;

        assertEquals(expected, actual);
    }
}
