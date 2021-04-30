/**TODO:
 *  1. Perform successful test of Exception thrown from multiplication
 *  2. Testing for Powers strategy and class
 */

package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import source.calculator.Addition;
import source.calculator.CalcStrategy;
import source.calculator.Multiplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalcStrategyTest {
    private CalcStrategy calcStrategy;

    @BeforeEach
    public void setUp() throws Exception {
        calcStrategy = new CalcStrategy();
    }

    @Test
    @DisplayName("CalcStrategy testing")
    public void testCalcStrategy() {
        calcStrategy = new CalcStrategy("1+1");
        assertEquals(2.0, calcStrategy.getC(), "Addition Strategy testing");
        calcStrategy = new CalcStrategy("1-1");
        assertEquals(0.0, calcStrategy.getC(), "Subtraction Strategy testing");
        calcStrategy = new CalcStrategy("1*1");
        assertEquals(1.0, calcStrategy.getC(), "Multiplication Strategy testing");
        calcStrategy = new CalcStrategy("1/1");
        assertEquals(1.0, calcStrategy.getC(), "Division Strategy testing");
    }

    @Test
    @DisplayName("Addition Testing")
    public void testAddition() {
        calcStrategy = new Addition(1, 1, 'a');
        assertEquals(2.0, calcStrategy.getC(), "Regular Addition");
        calcStrategy = new Addition(1, 0, 'a');
        assertEquals(1.0, calcStrategy.getC(), "Addition Identity testing");
        calcStrategy = new Addition(2, -1, 'a');
        assertEquals(1.0, calcStrategy.getC(), "Proper negative handling");
    }

    @Test
    @DisplayName("Subtraction Testing")
    public void testSubtraction() {
        calcStrategy = new Addition(1, 1, 's');
        assertEquals(0.0, calcStrategy.getC(), "Regular Subtraction");
        calcStrategy = new Addition(2, -1, 's');
        assertEquals(3.0, calcStrategy.getC(), "Proper negative handling");
    }

    @Test
    @DisplayName("Multiplication Testing")
    public void testMultiplication() {
        calcStrategy = new Multiplication(2, 2, 'm');
        assertEquals(4.0, calcStrategy.getC(), "Regular Multiplication");
        calcStrategy = new Multiplication(2, 1, 'm');
        assertEquals(2.0, calcStrategy.getC(), "Multiplication identity testing");
        calcStrategy = new Multiplication(2, 0, 'm');
        assertEquals(0.0, calcStrategy.getC(), "Multiplication by 0");
    }

    @Test
    @DisplayName("Division Testing")
    public void testDivision() {
        calcStrategy = new Multiplication(4, 2, 'd');
        assertEquals(2.0, calcStrategy.getC(), "Regular Division");
        calcStrategy = new Multiplication(2, 2, 'd');
        assertEquals(1.0, calcStrategy.getC(), "Division identity testing");
        //calcStrategy = new Multiplication(1, 0, 'd');
        //assertEquals(0.0, calcStrategy.getC(), "Error testing, sets C value in superclass to 0.0 if 0 is input and" +
        //        " throws an ArithmeticException");
        //assertThrows(ArithmeticException.class, () -> {calcStrategy = new Multiplication(1, 0, 'd');});
    }
}
