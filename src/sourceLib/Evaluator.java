package sourceLib;

public class Evaluator {

    public String expressionEvaluator(String exp) {
        int result = 0;
        String[] expression;
        String no1, no2, operator;
        expression = exp.split(" ");
        no1 = expression[0];
        no2 = expression[2];
        operator = expression[1];
        if (0 == "+".compareTo(operator))
            result = Integer.parseInt(no1) + Integer.parseInt(no2);
        return String.valueOf(result);
    }
}


