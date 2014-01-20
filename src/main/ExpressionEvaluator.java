package main;

import sourceLib.Evaluator;

public class ExpressionEvaluator {
    public static void main(String[] args) {
        String exp = "";
        String result;
        Evaluator eval = new Evaluator();
        result = eval.expressionEvaluator(exp);
        System.out.println(result);
    }
}


