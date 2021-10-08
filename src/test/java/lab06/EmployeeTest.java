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
 * Class: EmployeeTest
 *
 * Description:
 * Test class for the Employee class
 * ****************************************
 */

package lab06;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    /** Delta constant for checking floating point assertions */
    private static final double EPSILON = 1.0E-10;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * Test for the IDFactory to ensure the class is working properly
     */
    @Test
    void testIDFactory() {
        Employee emp1 = new Employee(100, "A", "B", 100000000, LocalDate.now(), 10000);
        Employee emp2 = new Employee(100, "A", "B", 100000000, LocalDate.now(), 10000);
        Employee emp3 = new Employee(-100, "A", "B", 100000000, LocalDate.now(), 10000);
        assertEquals(100, emp1.getEmpID());
        assertEquals(1, emp2.getEmpID());
        assertEquals(2, emp3.getEmpID());
    }

    /**
     * Testing the changeName method to ensure it is working properly
     */
    @Test
    void testChangeName() {
        Employee emp1 = new Employee(5, "A", "B", 100000000, LocalDate.now(), 10000);

        emp1.changeName("Y", "Z");

        assertEquals("Y", emp1.getFirstName());
        assertEquals("Z", emp1.getLastName());
    }

    /**
     * Testing the raiseSalary method to ensure it is working properly
     */
    @Test
    void testRaiseSalary() {
        Employee emp1 = new Employee(5, "A", "B", 100000000, LocalDate.now(), 10000);

        emp1.raiseSalary(5000);
        assertEquals(15000, emp1.getSalary());
    }

    /**
     * Testing the equals method to ensure it is working properly and overriding the default equals method
     */
    @Test
    void testEquals() {
        //Both ssNums are the same
        Employee emp1 = new Employee(5, "A", "B", 100000000, LocalDate.now(), 10000);
        Employee emp2 = new Employee(5, "A", "B", 100000000, LocalDate.now(), 10000);
        boolean what = emp1 == emp2;
        assertEquals(true, emp1.equals(emp2));
    }

    /**
     * Testing the Payable interface to ensure it is working properly
     */
    @Test
    void testPayable() {
        Employee emp = new Employee(1, "Brian", "King", 123459876, LocalDate.now(), 10 * 52 * 40);
        assertEquals(emp.getFirstName() + " " + emp.getLastName(), emp.getPayTo());
        assertEquals(400, emp.calculatePay(40), EPSILON);
        double test = emp.calculatePay(50);
        assertEquals(550, emp.calculatePay(50), EPSILON);
    }
}