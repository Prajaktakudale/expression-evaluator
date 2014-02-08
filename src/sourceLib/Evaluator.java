package sourceLib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Evaluator {
    private double calculateResult(List<Double> operands, List<String> operators, Operator op){
        double num1 = operands.get(0);
        for (int index = 0; index < operators.size(); index++)
            num1 = op.performOperation(operators.get(index), num1, operands.get(index + 1));
        return num1;
    }

    private void getOperandsAndOperators(String[] inputParts, List<Double> operands, List<String> operators) {
        String[] operatorAllowed = {"+","-","^","/","*"};
        for (String part : inputParts) {
            if(Arrays.asList(operatorAllowed).indexOf(part)>-1)
                operators.add(part);
            else
                operands.add(Double.parseDouble(part));
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
        List<Double> operands = new ArrayList<Double>();
        List<String> operators = new ArrayList<String>();
        if (inputExpr.contains("(")) {
            inputExpr = solveBrackets(inputExpr);
            return getResult(inputExpr);
        }
        String[] expressionParts = inputExpr.split("\\s+");
        getOperandsAndOperators(expressionParts, operands, operators);
        return calculateResult(operands, operators, operator);
    }
}