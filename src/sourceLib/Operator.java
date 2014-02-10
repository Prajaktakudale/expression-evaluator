package sourceLib;

import java.util.HashMap;
import java.util.Map;

interface Operation {
    public double operate(double operand1, double operand2);
}

public class Operator {
    Map<String, Operation> operatorMap = new HashMap<>();

    public Operator() {
        operatorMap.put("+", new Operation() {
            public double operate(double operand1, double operand2) {
                return operand1 + operand2;
            }
        });

        operatorMap.put("-", new Operation() {
            public double operate(double operand1, double operand2) {
                return operand1 - operand2;
            }
        });

        operatorMap.put("*", new Operation() {
            public double operate(double operand1, double operand2) {
                return operand1 * operand2;
            }
        });

        operatorMap.put("/", new Operation() {
            public double operate(double operand1, double operand2) {
                return operand1 / operand2;
            }
        });

        operatorMap.put("^", new Operation() {
            public double operate(double operand1, double operand2) {
                return Math.pow(operand1, operand2);
            }
        });
    }

    public double performOperation(String operator, double no1, double no2) {
        return operatorMap.get(operator).operate(no1, no2);
    }


}