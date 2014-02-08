package sourceLib;

import java.util.List;

/**
 * This class will parse the input and give list of operands and operators.
 */
public class InputParser {
    String input;

    public InputParser(String input) {
        this.input = input;
    }

    public void getOperandAndOperators(List<Double> operands, List<String> operators) {
        String input = new SpaceHandler(this.input).getExpressionWithSpace();
        String[] inputParts = input.split(" ");

        for (String value : inputParts) {
            try {
                operands.add(Double.parseDouble(value));
            } catch (Exception ex) {
                operators.add(value);
            }
        }
    }
}
