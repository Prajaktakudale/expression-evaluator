package main;

import sourceLib.Evaluator;

import java.io.IOException;

public class ExpressionEvaluator {
    public static void main(String[] args) throws IOException {
        Evaluator evaluator = new Evaluator(args[0]);
        try {
            System.out.println(evaluator.getResult());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


