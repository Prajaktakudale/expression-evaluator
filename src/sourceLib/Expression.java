package sourceLib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Expression {
    List<Double> operands = new ArrayList<>();
    List<String> operators = new ArrayList<>();

    private double calculateResult(Operator op){
        double num1 = this.operands.get(0);
        for (int index = 0; index < this.operators.size(); index++)
            num1 = op.performOperation(this.operators.get(index), num1, this.operands.get(index + 1));
        return num1;
    }

    private void getOperandsAndOperators(String[] inputParts) {
        String[] operatorAllowed = {"+","-","^","/","*"};
        for (String part : inputParts) {
            if(Arrays.asList(operatorAllowed).indexOf(part)>-1)
                this.operators.add(part);
            else
                this.operands.add(Double.parseDouble(part));
        }
    }

    private String solveBrackets(String expression){
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

    public double getResult(String expression){
        String inputExpr = new SpaceHandler(expression).getExpressionWithSpace();
        Operator operator = new Operator();
        if (inputExpr.contains("(")) {
            inputExpr = solveBrackets(inputExpr);
            return new Expression().getResult(inputExpr);
        }
        String[] expressionParts = inputExpr.split("\\s+");
        getOperandsAndOperators(expressionParts);
        return calculateResult(operator);
    }
}