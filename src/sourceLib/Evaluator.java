package sourceLib;

import java.util.ArrayList;
import java.util.List;


public class Evaluator extends Operation {
    String expr;

    public Evaluator(String expression) {
        super();
        this.expr = expression;
    }

    public String getExpression() {
        return this.expr;
    }

    private double ResultForBigExpression(List<Double> operands, List<String> operators, Operation op) throws Exception {
        double operator = operands.get(0);
        for (int index = 0; index < operators.size(); index++) {
            operator = op.calculateResult(operators.get(index), operator, operands.get(index + 1));
        }
        return operator;
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
        StringBuffer innerExpression = new StringBuffer(expression.substring(start + 1, end));
        double result = getResult(innerExpression.toString().trim());
        exp.replace(start, end + 1, Double.toString(result));
        return exp.toString().trim();
    }


    public String replacespace(String expr)throws Exception{
        return expr.trim().replaceAll(" +", " ")
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

    public double getResult(String exprInsideBracket) throws Exception {
        String inputExpr = replacespace(exprInsideBracket);
        String[] exprValues;
        Operation op = new Operation();
        List<Double> operands = new ArrayList<Double>();
        if (inputExpr.contains("(")) {
            inputExpr = brackets(inputExpr);
            return getResult(inputExpr);
        }
        exprValues = inputExpr.split("\\s+");
        List<String> operators = getOperandsAndOperators(exprValues, operands);
        double result = ResultForBigExpression(operands, operators, op);
        return result;
    }

    public double getResult() throws Exception {
        return getResult(this.expr);
    }
}