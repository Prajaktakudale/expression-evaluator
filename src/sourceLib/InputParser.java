package sourceLib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class will parse the input and give list of operands and operators.
 */
public class InputParser {
    private void getOperandsAndOperators(String[] inputParts, List<Expression> expressions, List<String> operators) {
        String[] operatorAllowed = {"+", "-", "^", "/", "*"};
        for (String part : inputParts) {
            if (Arrays.asList(operatorAllowed).indexOf(part) > -1)
                operators.add(part);
            else
                expressions.add(new Expression(Double.parseDouble(part)));
        }
    }

    public Expression parseInput(String expression) {
        String inputExpr = new SpaceHandler(expression).getExpressionWithSpace();
        if (inputExpr.contains("(")) return solveBrackets(inputExpr);
        String[] expressionParts = inputExpr.split("\\s+");
        List<Expression> expressions = new ArrayList<>();
        List<String> operators = new ArrayList<>();
        getOperandsAndOperators(expressionParts, expressions, operators);
        return new Expression(expressions, operators).calculateResult();
    }

    private Expression solveBrackets(String inputExpr) {
        StringBuilder exp = new StringBuilder(inputExpr);
        int startIndex = -1;
        int endIndex = -1;
        for (int index = 0; index < inputExpr.length(); index++) {
            if (inputExpr.charAt(index) == '(') {
                startIndex = index;
            }
            if (inputExpr.charAt(index) == ')') {
                endIndex = index;
                break;
            }
        }
        String innerExpression = inputExpr.substring(startIndex + 1, endIndex);
        double result = parseInput(innerExpression.trim()).getValue();
        exp.replace(startIndex, endIndex + 1, Double.toString(result));
        inputExpr = exp.toString().trim();
        return parseInput(inputExpr);
    }
}
