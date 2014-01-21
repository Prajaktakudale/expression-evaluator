package main;

import sourceLib.Evaluator;

import java.io.IOException;

public class ExpressionEvaluator {
    public static void main(String[] args) throws IOException{
        String result;
        Evaluator eval = new Evaluator();
        result = eval.expressionEvaluator(args[0]);
        System.out.println(result);
    }
}


