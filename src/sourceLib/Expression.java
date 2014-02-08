package sourceLib;

import java.util.ArrayList;
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

    public Expression calculateResult() {
        Operator op = new Operator();
        double result = this.operands.get(0).value;
        for (int index = 0; index < this.operators.size(); index++)
            result = op.performOperation(this.operators.get(index), result, this.operands.get(index + 1).value);
        this.value = result;
        return this;
    }

    public double getValue() {
        return value;
    }
}