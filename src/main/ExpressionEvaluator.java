package main;

import sourceLib.Evaluator;

public class ExpressionEvaluator {
    public static void main(String[] args) throws Exception {
        Evaluator evaluator = new Evaluator();
        System.out.println(evaluator.getResult(args[0]));
    }
}


