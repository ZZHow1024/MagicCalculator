/**
 * @author ZZHow
 * @date 2024/7/12
 */
public class Calculate {
    public static final int ADD = 0;
    public static final int SUBTRACT = 1;
    public static final int MULTIPLY = 2;
    public static final int DIVIDE = 3;

    public double cal(String expression) {
        expression = expression.substring(0, expression.length() - 2);
        if (expression.contains("+")) {
            String[] split = expression.split("\\+");
            double a = Double.parseDouble(split[0]);
            double b = Double.parseDouble(split[1]);
            return operate(a, b, ADD);
        } else if (expression.contains("-")) {
            String[] split = expression.split("-");
            double a = Double.parseDouble(split[0]);
            double b = Double.parseDouble(split[1]);
            return operate(a, b, SUBTRACT);
        } else if (expression.contains("×")) {
            String[] split = expression.split("×");
            double a = Double.parseDouble(split[0]);
            double b = Double.parseDouble(split[1]);
            return operate(a, b, MULTIPLY);
        } else if (expression.contains("÷")) {
            String[] split = expression.split("÷");
            double a = Double.parseDouble(split[0]);
            double b = Double.parseDouble(split[1]);
            return operate(a, b, DIVIDE);
        } else
            return Double.parseDouble(expression);
    }

    public double operate(double a, double b, int op) {
        return switch (op) {
            case ADD -> a + b;
            case SUBTRACT -> a - b;
            case MULTIPLY -> a * b;
            case DIVIDE -> a / b;
            default -> 0.0;
        };
    }
}
