package sourceLib;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test for space Handler.
 */
public class SpaceHandlerTest {
    @Test
    public void testInsertsSpacesInExpression() {
        String input = "1.5+2.4-4";
        SpaceHandler spaceHandler = new SpaceHandler(input);
        String expected = "1.5 + 2.4 - 4";

        String actual = spaceHandler.getExpressionWithSpace();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testInsertsSpacesInExpressionWhenCarretIsGiven() {
        String input = "1.5/2.4-4^4^4";
        SpaceHandler spaceHandler = new SpaceHandler(input);
        String expected = "1.5 / 2.4 - 4 ^ 4 ^ 4";

        String actual = spaceHandler.getExpressionWithSpace();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testInsertsSpacesInExpressionWhenBracketsAreGiven() {
        String input = "(1.5+(2.4-4)^4^4)";
        SpaceHandler spaceHandler = new SpaceHandler(input);
        String expected = "( 1.5 + ( 2.4 - 4 ) ^ 4 ^ 4 )";

        String actual = spaceHandler.getExpressionWithSpace();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testInsertsSpacesInExpressionWhenNumbersAreNegative() {
        String input = "(1.5+(2.4--4)^4^4+-2)";
        SpaceHandler spaceHandler = new SpaceHandler(input);
        String expected = "( 1.5 + ( 2.4 - -4 ) ^ 4 ^ 4 + -2 )";

        String actual = spaceHandler.getExpressionWithSpace();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testInsertsSpacesInExpressionIfSpeacesAreNotGiven() {
        String input = "( 1.5+ (2.4--4 )^4 ^4+ -2)";
        SpaceHandler spaceHandler = new SpaceHandler(input);
        String expected = "( 1.5 + ( 2.4 - -4 ) ^ 4 ^ 4 + -2 )";

        String actual = spaceHandler.getExpressionWithSpace();

        Assert.assertEquals(expected, actual);
    }
    
}
