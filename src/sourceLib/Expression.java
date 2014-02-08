package sourceLib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Expression {
    private List<Expression> operands = new ArrayList<>();
    private List<String> operators = new ArrayList<>();
    private double value;

    public Expression(double value) {
        this.value = value;
    }

    public Expression() {
    }

    private double calculateResult() {
        Operator op = new Operator();
        double num1 = this.operands.get(0).value;
        for (int index = 0; index < this.operators.size(); index++)
            num1 = op.performOperation(this.operators.get(index), num1, this.operands.get(index + 1).value);
        return num1;
    }

    private void getOperandsAndOperators(String[] inputParts) {
        String[] operatorAllowed = {"+", "-", "^", "/", "*"};
        for (String part : inputParts) {
            if (Arrays.asList(operatorAllowed).indexOf(part) > -1)
                this.operators.add(part);
            else
                this.operands.add(new Expression(Double.parseDouble(part)));
        }
    }

    private String solveBrackets(String expression) {
        StringBuilder exp = new StringBuilder(expression);
        int startIndex = -1;
        int endIndex = -1;
        for (int index = 0; index < expression.length(); index++) {
            if (expression.charAt(index) == '(') {
                startIndex = index;
            }
            if (expression.charAt(index) == ')') {
                endIndex = index;
                break;
            }
        }
        String innerExpression = expression.substring(startIndex + 1, endIndex);
        double result = getResult(innerExpression.trim());
        exp.replace(startIndex, endIndex + 1, Double.toString(result));
        return exp.toString().trim();
    }

    public double getResult(String expression) {
        String inputExpr = new SpaceHandler(expression).getExpressionWithSpace();
        if (inputExpr.contains("(")) {
            inputExpr = solveBrackets(inputExpr);
            return new Expression().getResult(inputExpr);
        }
        String[] expressionParts = inputExpr.split("\\s+");
        getOperandsAndOperators(expressionParts);
        return calculateResult();
    }
}