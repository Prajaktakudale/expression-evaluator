package sourceLib;

import java.util.ArrayList;
import java.util.List;


public class Evaluator {
    String expr;

    public Evaluator(String expression) {
        this.expr = expression;
    }

    public String getExpression() {
        return this.expr;
    }

    private double ResultForBigExpression(List<Double> operands, List<String> operators, Operator op) throws Exception {
        double num1 = operands.get(0);
        for (int index = 0; index < operators.size(); index++) {
            num1 = op.calculateResult(operators.get(index), num1, operands.get(index + 1));
        }
        return num1;
    }

    private List<String> getOperandsAndOperators(String[] values, List<Double> operands) throws Exception{
        List<String> operators = new ArrayList<String>();
        for (String operator : values) {
            try {
                operands.add(Double.parseDouble(operator));
            } catch (Exception ex) {
                operators.add(operator);
            }
        }
        return operators;
    }

    private String brackets(String expression) throws Exception {
        StringBuilder exp = new StringBuilder(expression);
        int start = 0;
        int end = 0;
        for (int index = 0; index < expression.length(); index++) {
            if (expression.charAt(index) == '(') {
                start = index;
            }
            if (expression.charAt(index) == ')') {
                end = index;
                break;
            }
        }
        StringBuilder innerExpression = new StringBuilder(expression.substring(start + 1, end));
        double result = getResult(innerExpression.toString().trim());
        exp.replace(start, end + 1, Double.toString(result));
        return exp.toString().trim();
    }

    public double getResult(String exprInsideBracket) throws Exception {
        String inputExpr = new SpaceHandler(exprInsideBracket).getExpressionWithSpace();
        String[] exprValues;
        Operator op = new Operator();
        List<Double> operands = new ArrayList<Double>();
        if (inputExpr.contains("(")) {
            inputExpr = brackets(inputExpr);
            return getResult(inputExpr);
        }
        exprValues = inputExpr.split("\\s+");
        List<String> operators = getOperandsAndOperators(exprValues, operands);
        return ResultForBigExpression(operands, operators, op);
    }

    public double getResult() throws Exception {
        return getResult(this.expr);
    }
}