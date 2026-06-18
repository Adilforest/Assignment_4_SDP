package interpreter;

/**
 * Utility class that tokenises a simple arithmetic string and builds a left-to-right
 * composite {@link Expression} tree of {@link NumberExpression} leaves connected by
 * {@link OperatorExpression} nodes.
 *
 * <p>Supported grammar (integers only, operators + and -):</p>
 * <pre>
 *   expr  ::= number ( ( '+' | '-' ) number )*
 *   number ::= ['-']? [0-9]+
 * </pre>
 *
 * <p>Whitespace between tokens is ignored.</p>
 */
public final class Interpreter {

    private Interpreter() {}

    /**
     * Parses {@code input} and returns a root {@link Expression} whose
     * {@link Expression#interpret()} yields the arithmetic result.
     *
     * @param input e.g. {@code "1 + 2 + 3 - 4"}
     * @return root expression node
     * @throws IllegalArgumentException if the input is malformed
     */
    public static Expression parse(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Input must not be blank");
        }

        // Strip all spaces so we can iterate character by character.
        String src = input.replaceAll("\\s+", "");

        if (src.isEmpty()) {
            throw new IllegalArgumentException("Input contains no tokens");
        }

        // Walk through the stripped string, collecting number literals and operators.
        int i = 0;
        int len = src.length();

        // Parse the first (mandatory) number, which may start with '-'.
        int[] result = readNumber(src, i, len);
        Expression tree = new NumberExpression(result[0]);
        i = result[1];

        while (i < len) {
            char op = src.charAt(i);
            if (op != '+' && op != '-') {
                throw new IllegalArgumentException(
                        "Expected operator '+' or '-' at position " + i + " in \"" + src + "\"");
            }
            i++;

            result = readNumber(src, i, len);
            Expression right = new NumberExpression(result[0]);
            i = result[1];

            tree = new OperatorExpression(tree, right, op);
        }

        return tree;
    }

    /**
     * Reads a (possibly negative) integer starting at {@code start} within {@code src}.
     *
     * @return int[2] where [0] is the parsed value and [1] is the index after the last digit
     */
    private static int[] readNumber(String src, int start, int len) {
        if (start >= len) {
            throw new IllegalArgumentException("Expected a number but reached end of input");
        }

        int i = start;
        int sign = 1;

        // A '-' here is a unary minus on the very first character or directly after an operator.
        if (src.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        if (i >= len || !Character.isDigit(src.charAt(i))) {
            throw new IllegalArgumentException(
                    "Expected digit at position " + i + " in \"" + src + "\"");
        }

        int value = 0;
        while (i < len && Character.isDigit(src.charAt(i))) {
            value = value * 10 + (src.charAt(i) - '0');
            i++;
        }

        return new int[]{sign * value, i};
    }
}
