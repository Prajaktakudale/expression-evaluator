package sourceLib;

import java.util.HashMap;
import java.util.Map;

public class Operator {
    double answer;

    public double performOperation(String operator, double no1, double no2){
        Map<String, Operation> map = new HashMap<String, Operation>();

        map.put("+", new Operation() {
            public void operate(double operand1, double operand2) {
                answer = operand1 + operand2;
            }
        });

        map.put("-", new Operation() {
            public void operate(double operand1, double operand2) {
                answer = operand1 - operand2;
            }
        });

        map.put("*", new Operation() {
            public void operate(double operand1, double operand2) {
                answer = operand1 * operand2;
            }
        });

        map.put("/", new Operation() {
            public void operate(double operand1, double operand2) {
                answer = operand1 / operand2;
            }
        });

        map.put("^", new Operation() {
            public void operate(double operand1, double operand2) {
                answer = Math.pow(operand1, operand2);
            }
        });

        map.get(operator).operate(no1, no2);
        return answer;
    }


}