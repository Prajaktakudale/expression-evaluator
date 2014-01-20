package main;

import sourceLib.Evaluator;

public class ExpressionEvaluator {
    public static void main(String[] args) {
        Evaluator e = new Evaluator();
        int result = e.add(5,2);
        System.out.println(result);
    }
}