public class Calculator1 {
    public static float add(float num1, float num2) {
        return num1 + num2;
    }

    public static float subtract(float num1, float num2) {
        return num1 - num2;
    }

    public static float multiply(float num1, float num2) {
        return num1 * num2;
    }

    public static float divide(float num1, float num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero!");
        }
        return num1 / num2;
    }
}
