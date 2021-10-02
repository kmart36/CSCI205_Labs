/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2021
 * Instructor: Prof. Brian King
 *
 * Name: Katy Martinson
 * Section: 9:30am
 * Date: 9/30/2021
 * Time: 3:53 PM
 *
 * Project: csci205_labs
 * Package: lab05
 * Class: CalculatorTest
 *
 * Description:
 * A test class for our Calculator class that tests all methods
 * ****************************************
 */

package lab05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calc;

    /**
     * Creates a calculator object to test with
     */
    @BeforeEach
    void setUp() {
        this.calc = new Calculator(BinaryOperators.perm, "perm");
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * A test to make sure getAnswer is working properly
     */
    @Test
    void getAnswer() {
        this.calc.setOperands(7, 4);
        assertEquals(840, this.calc.getAnswer());
    }

    /**
     * Verify that getAnswer throws an ArithmeticException if operands
     * have not been set
     */
    @Test
    void getAnswerException() {
        assertThrows(ArithmeticException.class, () -> calc.getAnswer());
    }

    /**
     * A test to make sure setOperator is working properly
     */
    @Test
    void setOperator() {
        this.calc.setOperands(7, 4);
        assertEquals(840, this.calc.getAnswer());
        this.calc.setOperator(BinaryOperators.comb);
        assertEquals(35, this.calc.getAnswer());
    }

    /**
     * A test to make sure setOperands is working properly
     */
    @Test
    void setOperands() {
        this.calc.setOperands(7, 4);
        assertEquals(840, this.calc.getAnswer());
        this.calc.setOperands(5, 2);
        assertEquals(20, this.calc.getAnswer());
    }

    /**
     * A test to make sure toString is working properly
     * Points out that even though the operand changes, the friendly name does not
     * Friendly name will always remain the same as when the calculator was
     * first created
     */
    @Test
    void testToString() {
        assertEquals("perm(?, ?) = ?", this.calc.toString());
        this.calc.setOperands(7, 4);
        assertEquals("perm(7, 4) = 840", this.calc.toString());
        this.calc.setOperands(5, 3);
        assertEquals("perm(5, 3) = 60", this.calc.toString());
        this.calc.setOperator(BinaryOperators.comb);
        assertEquals("perm(5, 3) = 10", this.calc.toString());
    }
}