package sourceLib;

public class Evaluator {

    public String expressionEvaluator(String exp) {
        double result = 0;
        String[] expression;
        String no1, no2, operator;
        expression = exp.split(" ");
        no1 = expression[0];
        operator = expression[1];
        no2 = expression[2];
        if (0 == "+".compareTo(operator))
            result = Integer.parseInt(no1) + Integer.parseInt(no2);
        if (0 == "-".compareTo(operator))
            result = Integer.parseInt(no1) - Integer.parseInt(no2);
        if (0 == "*".compareTo(operator))
            result = Integer.parseInt(no1) * Integer.parseInt(no2);
        if (0 == "/".compareTo(operator))
            result = Integer.parseInt(no1) / Integer.parseInt(no2);
        if (0 == "^".compareTo(operator))
            result =  Math.pow(Integer.parseInt(no1),Integer.parseInt(no2));
        return String.valueOf(result);
    }
}