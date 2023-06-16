import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Calculator2 {

    @Test
    public void testAddition() {
        float result = Calculator.add(2.5f, 3.5f);
        assertEquals(6.0f, result, 0.001f);
    }

    @Test
    public void testSubtraction() {
        float result = Calculator.subtract(5.0f, 2.5f);
        assertEquals(2.5f, result, 0.001f);
    }

    @Test
    public void testMultiplication() {
        float result = Calculator.multiply(2.5f, 3.0f);
        assertEquals(7.5f, result, 0.001f);
    }

    @Test
    public void testDivision() {
        float result = Calculator.divide(10.0f, 2.5f);
        assertEquals(4.0f, result, 0.001f);
    }
}
