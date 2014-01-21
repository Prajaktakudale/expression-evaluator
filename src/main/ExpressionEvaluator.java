package main;

import sourceLib.Evaluator;

public class ExpressionEvaluator {
    public static void main(String[] args) {
        String result;
        Evaluator eval = new Evaluator();
        result = eval.expressionEvaluator(args[0]);
        System.out.println(result);
    }
}


