package main;

import sourceLib.Expression;

public class ExpressionEvaluator {
    public static void main(String[] args) throws Exception {
        Expression expression = new Expression();
        System.out.println(expression.parseInput(args[0]));
    }
}


