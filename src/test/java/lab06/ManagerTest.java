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
 * Class: ManagerTest
 *
 * Description:
 * A test class for the Manager test
 * ****************************************
 */

package lab06;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    private Manager mgr;
    private Employee emp1;
    private Employee emp2;

    @BeforeEach
    void setUp() {
        mgr = new Manager(1, "Erin", "Jablonski", 123456789, HRDateUtils.strToDate("2021-07-15"),
                100000.0, "ENGINEERING");
        emp1 = new Employee(1, "Brian", "King", 123456789, HRDateUtils.strToDate("2010-08-20"), 60000);
        emp2 = new Employee(2, "Chris", "Dancy", 402040302, HRDateUtils.strToDate("2015-07-02"), 65000);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addEmployee() throws ManagerException {
        mgr.addEmployee(emp1);
        mgr.addEmployee(emp2);
        assertEquals(emp1, mgr.getEmpList().get(0));
        assertEquals(emp2, mgr.getEmpList().get(1));
    }

    /**
     * A test to ensure that addEmployee throws a ManagerException when expected
     * @throws ManagerException Exception thrown when an employee is already in the list and is attempted to be added again
     */
    @Test
    void addEmployeeException() throws ManagerException {
        mgr.addEmployee(emp1);
        // Add the same employee into the list
        assertThrows(ManagerException.class, () -> mgr.addEmployee(emp1));
    }

    /**
     * Tests the removeEmployee method to ensure it is working properly
     * @throws ManagerException Exception thrown when an employee not in the list is attempted to be removed
     */
    @Test
    void removeEmployee() throws ManagerException {
        mgr.addEmployee(emp1);
        mgr.addEmployee(emp2);
        mgr.removeEmployee(emp1);
        assertEquals(emp2, mgr.getEmpList().get(0));
    }

    /**
     * A test to ensure that removeEmployee throws a ManagerException when expected
     * @throws ManagerException Exception thrown when an employee not in the list is attempted to be removed
     */
    @Test
    void removeEmployeeException() throws ManagerException {
        assertThrows(ManagerException.class, () -> mgr.removeEmployee(emp1));
    }
}