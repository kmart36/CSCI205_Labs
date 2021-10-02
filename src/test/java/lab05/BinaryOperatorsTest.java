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
 * Class: BinaryOperatorsTest
 *
 * Description:
 * A test class for the BinaryOperators class
 * ****************************************
 */

package lab05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryOperatorsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * A test to make sure combination is working properly
     */
    @Test
    void combinationTest() {
        MathOp op = BinaryOperators.comb;
        assertEquals(7, op.func(7, 1));
        assertEquals(35, op.func(7, 4));
        assertEquals(1, op.func(7, 7));
    }

    /**
     * A test to make sure permutation is working properly
     */
    @Test
    void permutationTest() {
        MathOp op = BinaryOperators.perm;
        assertEquals(7, op.func(7, 1));
        assertEquals(840, op.func(7, 4));
        assertEquals(5040, op.func(7, 7));
    }

    /**
     * A test to make sure gcd is working properly
     */
    @Test
    void gcdTest() {
        MathOp op = BinaryOperators.gcd;
        assertEquals(1, op.func(1, 10));
        assertEquals(1, op.func(10, 1));
        assertEquals(1, op.func(3, 11));
        assertEquals(1, op.func(11, 3));
        assertEquals(9, op.func(243, 45));
        assertEquals(9, op.func(45, 243));
    }

    /**
     * A test to make sure lcm is working properly
     */
    @Test
    void lcmTest() {
        MathOp op = BinaryOperators.lcm;
        assertEquals(12, op.func(3, 4));
        assertEquals(12, op.func(4, 3));
        assertEquals(10, op.func(1, 10));
        assertEquals(10, op.func(10, 1));
        assertEquals(144, op.func(18, 16));
        assertEquals(144, op.func(16, 18));
    }
}