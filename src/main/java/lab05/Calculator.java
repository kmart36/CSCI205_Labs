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
 * Class: Calculator
 *
 * Description:
 * A calculator class that allows one calculation per calculator and two operands
 * ****************************************
 */
package lab05;

public class Calculator {

    private MathOp operation;
    private String operationName;
    private int oper1;
    private int oper2;


    /**
     * Constructor for the Calculator class
     * @param operator - MathOp operation that the Calculator is able to calculate
     * @param opName - Friendly name for the operation
     */
    public Calculator(MathOp operator, String opName) {
        this.operation = operator;
        this.operationName = opName;
    }

    /**
     * Setter method that allows the user to change the operands for the calculator
     * @param operand1 - First operand, either n for comb and perm or a for gcd and lcm
     * @param operand2 - Second operand, either r for comb and perm or b for gcd and lcm
     */
    public void setOperands(int operand1, int operand2) {
        this.oper1 = operand1;
        this.oper2 = operand2;
    }

    /**
     * Setter method that allows the user to chance the operator for the calculator
     * DOES NOT CHANGE FRIENDLY NAME
     * @param operator - New MathOp operator
     */
    public void setOperator(MathOp operator) {
        this.operation = operator;
    }

    public int getAnswer() throws ArithmeticException {
        if (this.oper1 == 0 || this.oper2 == 0) {
            String msg = "No operands have been set";
            throw new ArithmeticException(msg);
        }
        return operation.func(oper1, oper2);
    }

    /**
     * @return - String representation of the calculator input, computation, and output
     */
    @Override
    public String toString() {
        if (this.oper1 == 0 || this.oper2 == 0) {
            return this.operationName + "(?, ?) = ?";
        }
        return this.operationName + "(" + oper1 + ", " + oper2 + ") = "
                + this.getAnswer();
    }
}