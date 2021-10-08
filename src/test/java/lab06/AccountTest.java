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
 * Class: AccountTest
 *
 * Description:
 * Test class for the Account class
 * ****************************************
 */

package lab06;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    /** Delta constant for checking floating point assertions */
    private static final double EPSILON = 1.0E-10;

    private Account acct;
    private Employee emp;

    /**
     * Instantiates an Account and an Employee to use for testing
     */
    @BeforeEach
    void setUp() {
        // Set up an account to have 1000 initial balance
        this.acct = new Account(1000.0);

        // Set up the test employee to be paid $10/hr
        this.emp = new Employee(1, "Brian", "King", 123459876,
                LocalDate.now(), 10 * 52 * 40);

        // Let's just check the account to indeed have 1000
        assertEquals(1000.0, acct.getBalance(), EPSILON);
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * Testing the credit method to ensure it is working properly
     */
    @Test
    void credit() {
        assertEquals(1000.0, acct.getBalance(), EPSILON);
        this.acct.credit(1000.0);
        assertEquals(2000.0, acct.getBalance(), EPSILON);
    }

    /**
     * Testing the debit method to ensure it is working properly
     */
    @Test
    void debit() throws InsufficientFundsException {
        assertEquals(1000.0, acct.getBalance(), EPSILON);
        this.acct.debit(250.0);
        assertEquals(750.0, acct.getBalance(), EPSILON);
    }

    /**
     * Testing the prepareCheckAndDebit method to ensure it is working properly
     */
    @Test
    void prepareCheckAndDebit() throws InsufficientFundsException {
        acct.prepareCheckAndDebit(emp, 40);
        assertEquals(1000 - 400, acct.getBalance(), EPSILON);

        // Let's verify the check amount here
        assertEquals(400, acct.getCheckAmount(), EPSILON);
    }

    /**
     * Testing the writeCheck method to ensure it is working properly
     */
    @Test
    void writeCheck() throws InsufficientFundsException {
        acct.prepareCheckAndDebit(emp, 40);
        String sResult = acct.writeCheck();
        assertTrue(sResult != null);
        assertFalse(sResult.equals(""));
        System.out.println(acct.writeCheck());
    }

    /**
     * Testing the debitException to ensure that the Exception is thrown when it should be thrown
     */
    @Test
    void debitException() {
        assertThrows(InsufficientFundsException.class, () -> acct.debit(2000.0));
    }
}