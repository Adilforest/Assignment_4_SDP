package interpreter;

public class Interpreter {
    public static Expression parse(String input) {
        input = input.replaceAll("\\s", "");

        int pos = input.length() - 1;

        while (pos > 0) {
            if (Character.isDigit(input.charAt(pos))) {
                pos--;
            } else {
                Expression left = parse(input.substring(0, pos));
                Expression right = new NumberExpression(Integer.parseInt(input.substring(pos + 1)));
                char operator = input.charAt(pos);
                return new OperatorExpression(left, right, operator);
            }
        }

        int result = Integer.parseInt(input);
        return new NumberExpression(result);
    }
}
