package sourceLib;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Test for Input Parser.
 */
public class InputParserTest {
    @Test
    public void shouldGiveListOfOperatorsAndOperands(){
        String input = "2 + 4";
        List<Double> operands = new ArrayList<Double>();
        List<String> operators = new ArrayList<String>();

        new InputParser(input).getOperandAndOperators(operands,operators);

        Assert.assertEquals(2.0,operands.get(0));
        Assert.assertEquals(4.0,operands.get(1));
        Assert.assertEquals("+",operators.get(0));
    }

    @Test
    public void shouldGiveListOfOperatorsAndOperandsWhenExpressionDoesNotContainSpaces(){
        String input = "23+4^7";
        List<Double> operands = new ArrayList<Double>();
        List<String> operators = new ArrayList<String>();

        new InputParser(input).getOperandAndOperators(operands,operators);

        Assert.assertEquals(23.0,operands.get(0));
        Assert.assertEquals(4.0,operands.get(1));
        Assert.assertEquals(7.0,operands.get(2));
        Assert.assertEquals("+",operators.get(0));
        Assert.assertEquals("^",operators.get(1));
    }
}
