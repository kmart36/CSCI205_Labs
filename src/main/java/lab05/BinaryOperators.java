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
 * Class: BinaryOperators
 *
 * Description:
 * A binary operations class that uses our MathOp interface to make specific
 * operations for our calculator to use
 * ****************************************
 */
package lab05;

public class BinaryOperators {


    /**
     * Helper method that computes the factorial of input n
     * @param n
     * @return n!
     */
    private static int factorial(int n) {
        int i = 1;
        int j = 1;
        while (j <= n) {
            i *= j;
            j++;
        }
        return i;
    }

    /**
     * Computes the nCr (combination) of n and r
     */
    public static MathOp comb = (n, r) -> factorial(n) / (factorial(r) * factorial(n - r));

    /**
     * Computes the nPr (permutation) of n and r
     */
    public static MathOp perm = (n, r) -> factorial(n) / factorial(n - r);

    /**
     * Finds the greatest common divisor between a and b
     */
    public static MathOp gcd = (a, b) -> {
        int gcd = 1;
        for (int i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    };

    /**
     * Finds the least common multiple of a and b
     */
    public static MathOp lcm = (a, b) -> {
        int leastMultiple = a * b;
        for (int i = leastMultiple; i >= a && i >= b; i--) {
            if (i % a == 0 && i % b == 0) {
                leastMultiple = i;
            }
        }
        return leastMultiple;
    };
}