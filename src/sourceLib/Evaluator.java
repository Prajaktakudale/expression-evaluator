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
        public int getResult() throws Exception {
        String[] values = this.expr.split(" ");
        List<Integer> operands = new ArrayList<Integer>();
        List<String> operators = getOperandsAndOperators(values, operands);
        Operation op = new Operation();
        return ResultForBigExpression(operands, operators, op);
    }
}