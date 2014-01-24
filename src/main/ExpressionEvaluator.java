package main;

import sourceLib.Evaluator;

public class ExpressionEvaluator {
    public static void main(String[] args) throws Exception {
        Evaluator evaluator = new Evaluator(args[0]);
        System.out.println(evaluator.getResult());
    }
}


