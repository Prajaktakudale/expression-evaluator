package sourceLib;

import java.util.HashMap;
import java.util.Map;

interface Operators {
    void operate(double operand1, double operand2);
}

public class Operation {
    double answer;

    public double calculateResult(String operator, double no1, double no2) throws Exception {
        Map<String, Operators> map = new HashMap<String, Operators>();

        map.put("+", new Operators() {
            public void operate(double operand1, double operand2) {
                answer = operand1 + operand2;
            }
        });

        map.put("-", new Operators() {
            public void operate(double operand1, double operand2) {
                answer = operand1 - operand2;
            }
        });

        map.put("*", new Operators() {
            public void operate(double operand1, double operand2) {
                answer = operand1 * operand2;
            }
        });

        map.put("/", new Operators() {
            public void operate(double operand1, double operand2) {
                answer = operand1 / operand2;
            }
        });

        map.put("^", new Operators() {
            public void operate(double operand1, double operand2) {
                answer = Math.pow(operand1, operand2);
            }
        });

        map.get(operator).operate(no1, no2);
        return answer;
    }


}