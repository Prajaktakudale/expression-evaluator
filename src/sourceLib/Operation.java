package sourceLib;

import java.util.HashMap;
import java.util.Map;

interface Operators {
    void operate(int operand1, int operand2);
}

public class Operation {
    int answer;

    public int calculateResult(String operator, int no1, int no2) throws Exception {
        Map<String, Operators> map = new HashMap<String, Operators>();

        map.put("+", new Operators() {
            public void operate(int operand1, int operand2) {
                answer = operand1 + operand2;
            }
        });

        map.put("-", new Operators() {
            public void operate(int operand1, int operand2) {
                answer = operand1 - operand2;
            }
        });

        map.put("*", new Operators() {
            public void operate(int operand1, int operand2) {
                answer = operand1 * operand2;
            }
        });

        map.put("/", new Operators() {
            public void operate(int operand1, int operand2) {
                answer = operand1 / operand2;
            }
        });

        map.put("^", new Operators() {
            public void operate(int operand1, int operand2) {
                answer = (int) Math.pow(operand1, operand2);
            }
        });

        map.get(operator).operate(no1, no2);
        return answer;
    }


}