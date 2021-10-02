/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2021
 *
 * Name: Katy Martinson
 * Date: 9/30/21
 * Time: 9:40 AM
 *
 * Project: csci205_labs
 * Package: lab05
 * Class: MathOp
 * Description:
 * A function interface that our operations class will use to
 * define specific operations
 * ****************************************
 */

package lab05;

@FunctionalInterface
public interface MathOp {
    int func(int x, int y);
}
