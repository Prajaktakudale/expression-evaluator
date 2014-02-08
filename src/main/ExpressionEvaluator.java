package main;

import sourceLib.InputParser;

public class ExpressionEvaluator {
    public static void main(String[] args) throws Exception {
        InputParser inputParser = new InputParser();
        System.out.println(inputParser.parseInput(args[0]).getValue());
    }
}


