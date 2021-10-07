package lab06;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    private static final double EPSILON = 1.0E-10;
    private Account acct;
    private Employee emp;

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

    @Test
    void credit() {
        assertEquals(1000.0, acct.getBalance(), EPSILON);
        this.acct.credit(1000.0);
        assertEquals(2000.0, acct.getBalance(), EPSILON);
    }

    @Test
    void debit() throws InsufficientFundsException {
        assertEquals(1000.0, acct.getBalance(), EPSILON);
        this.acct.debit(250.0);
        assertEquals(750.0, acct.getBalance(), EPSILON);
    }

    @Test
    void prepareCheckAndDebit() throws InsufficientFundsException {
        acct.prepareCheckAndDebit(emp, 40);
        assertEquals(1000 - 400, acct.getBalance(), EPSILON);

        // Let's verify the check amount here
        assertEquals(400, acct.getCheckAmount(), EPSILON);
    }

    @Test
    void writeCheck() throws InsufficientFundsException {
        acct.prepareCheckAndDebit(emp, 40);
        String sResult = acct.writeCheck();
        assertTrue(sResult != null);
        assertFalse(sResult.equals(""));
        System.out.println(acct.writeCheck());
    }

    @Test
    void debitException() {
        assertThrows(InsufficientFundsException.class, () -> acct.debit(2000.0));
    }
}