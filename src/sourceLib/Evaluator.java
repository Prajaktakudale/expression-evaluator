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

    private int ResultForBigExpression(List<Integer> operands, List<String> operators, Operation op) throws Exception {
        int index;
        int result = op.calculateResult(operators.get(0), operands.get(0), operands.get(1));
        for (index = 1; index < operators.size(); index++) {
            result = op.calculateResult(operators.get(index), result, operands.get(index + 1));
        }
        return result;
    }

    private List<String> getOperandsAndOperators(String[] values, List<Integer> operands) {
        List<String> operators = new ArrayList<String>();
        for (String operator : values) {
            try {
                operands.add(Integer.parseInt(operator));
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
        int result = getResult(innerExpression.toString().trim());
        exp.replace(start, end + 1, Integer.toString(result));
        return exp.toString().trim();
    }

    public int getResult() throws Exception {
        return getResult(this.expr);
    }

    public int getResult(String exprInsideBracket) throws Exception {
        String inputExpr = exprInsideBracket;
        String[] exprValues;
        Operation op = new Operation();
        List<Integer> operands = new ArrayList<Integer>();
        if (inputExpr.contains("(")) {
            inputExpr = brackets(inputExpr);
            return getResult(inputExpr);
        }
        exprValues = inputExpr.split(" ");
        List<String> operators = getOperandsAndOperators(exprValues, operands);
        int result = ResultForBigExpression(operands, operators, op);
        return result;
    }

}