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

    public Expression(List<Expression> operands, List<String> operators) {
        this.operands = operands;
        this.operators = operators;
    }

    public Expression() {
    }

    public Expression calculateResult() {
        Operator op = new Operator();
        double result = this.operands.get(0).value;
        for (int index = 0; index < this.operators.size(); index++)
            result = op.performOperation(this.operators.get(index), result, this.operands.get(index + 1).value);
        this.value = result;
        return this;
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

    public Expression parseInput(String expression) {
        String inputExpr = new SpaceHandler(expression).getExpressionWithSpace();
        if (inputExpr.contains("(")) {
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
            double result = parseInput(innerExpression.trim()).value;
            exp.replace(startIndex, endIndex + 1, Double.toString(result));
            inputExpr = exp.toString().trim();
            return new Expression().parseInput(inputExpr);
        }
        String[] expressionParts = inputExpr.split("\\s+");
        getOperandsAndOperators(expressionParts);
        return new Expression(operands,operators).calculateResult();
    }

    public double getValue() {
        return value;
    }
}