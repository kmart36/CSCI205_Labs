/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2021
 * Instructor: Prof. Brian King
 *
 * Name: Katy Martinson and Phil Morgan
 * Section: 9:30am
 * Date: 10/7/2021
 * Time: 6:59 PM
 *
 * Project: csci205_labs
 * Package: lab06
 * Class: Payable
 *
 * Description:
 * An interface implemented by all objects that are payable (Employee, Manager, and Contractor)
 * ****************************************
 */

package lab06;

/**
 * Payable interface implemented by all classes that are payable by an Account (Employee, Manager, and Contractor
 */
public interface Payable {
    double calculatePay(double numHrs);
    String getPayTo();
    String getPayMemo();
}
