package interpreter;

public class OperatorExpression implements Expression {
    private final char operator;
    private final Expression leftOperator;
    private final Expression rightOperator;

    public OperatorExpression(Expression leftOperator, Expression rightOperator, char operator) {
        this.operator = operator;
        this.leftOperator = leftOperator;
        this.rightOperator = rightOperator;
    }

    public int interpret() {
        if (operator == '+')
            return leftOperator.interpret() + rightOperator.interpret();
        else if (operator == '-')
            return leftOperator.interpret() - rightOperator.interpret();


        throw new IllegalArgumentException("Invalid operator");
    }
}