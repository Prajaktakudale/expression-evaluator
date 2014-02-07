package sourceLib;

/**
 * This class will convert the expression in appropriate format.
 */
public class SpaceHandler {
    String expression;

    public SpaceHandler(String input) {
        this.expression = input;
    }

    public String getExpressionWithSpace(){
        String expr = this.expression.replaceAll(" +","");
        return expr.trim().replaceAll(" +", " ")
                .replaceAll(" -- ", "+")
                .replaceAll("\\+", " + ")
                .replaceAll("\\-", " - ")
                .replaceAll("\\*", " * ")
                .replaceAll("\\/", " / ")
                .replaceAll("\\^", " ^ ")
                .replaceAll("\\(", "( ")
                .replaceAll("\\)", " )")
                .replaceAll("  - ", " -")
                .replaceAll("^ - ", "-")
                .replaceAll("^\\( - ", "(-")
                .replaceAll("\\--", " + ");
    }
}
