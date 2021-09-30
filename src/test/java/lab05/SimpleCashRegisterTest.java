/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2021
 *
 * Name: Katy Martinson
 * Date: 9/29/21
 * Time: 9:40 AM
 *
 * Project: csci205_labs
 * Package: lab05
 * Class: SimpleCashRegisterTest
 * Description:
 * Test class for the SimpleCashRegister
 * ****************************************
 */

package lab05;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCashRegisterTest {

    /** Delta constant for checking floating point assertions */
    private static final double EPSILON = 1.0E-12;

    /** Cash register used in every test */
    private SimpleCashRegister register;

    @BeforeEach
    void setUp() {
        this.register = new SimpleCashRegister();
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * A test to make sure our getPurchaseCount method is working properly
     */
    @Test
    void getPurchaseCount() {

        // A new register should have 0 purchases
        assertEquals(0, register.getPurchaseCount(), EPSILON);

        // Purchase two items, and verify it to be correct
        register.scanItem(0.55);
        register.scanItem(1.27);
        assertEquals(2, register.getPurchaseCount());

    }

    /**
     * A test to make sure exceptions are thrown when we expect them to, and
     * NOT thrown when everything is OK
     */
    @Test
    @DisplayName("scanItem() - bad scan value")
    void scanItemException() {
        // Scan for a negative price
        assertThrows(IllegalArgumentException.class, () -> register.scanItem(-0.5));

        // Scan for a ridiculously bigly huge large price
        assertThrows(IllegalArgumentException.class, () -> register.scanItem(10000.0));
    }

    /**
     * A test to make sure getListOfPurchases is working properly
     */
    @Test
    void getListOfPurchases() {
        // A new register should have 0 purchases in list
        assertEquals(0, register.getListOfPurchases().size());

        register.scanItem(8.80);
        register.scanItem(2.09);

        // After scanning 2 items, the list size should increase by 2.
        assertEquals(2, register.getListOfPurchases().size());

        // First item in the list should be 8.80
        assertEquals(8.80, register.getListOfPurchases().get(0), EPSILON);

        // Second item in the list should be 2.09
        assertEquals(2.09, register.getListOfPurchases().get(1), EPSILON);
    }

    /**
     * A test to make sure getTransactionTotal is working properly
     */
    @Test
    void getTransactionTotal() {
        // A new register should have a transaction total of 0
        assertEquals(0.0, register.getTransactionTotal(), EPSILON);

        // Scan 2 items and check again
        register.scanItem(0.55);
        register.scanItem(1.27);
        assertEquals(1.82, register.getTransactionTotal(), EPSILON);
    }

    /**
     * A test to make sure collectPayment is working properly
     */
    @Test
    void collectPayment() {
        // No payment should be collected with a new register
        assertEquals(0.0, register.getPaymentCollected(), EPSILON);

        register.collectPayment(Money.DIME, 22);
        register.collectPayment(Money.DOLLAR, 3);

        // Collected $5.20, getPaymentCollected should be the same
        assertEquals(5.20, register.getPaymentCollected(), EPSILON);
    }

    /**
     * A test to make sure exceptions are thrown when we expect them to, and
     * NOT thrown when everything is OK
     */
    @Test
    void collectPaymentException() {
        // Scan for negative payment
        assertThrows(IllegalArgumentException.class, () -> register.collectPayment(Money.FIVE, -4));
    }

    /**
     * A test to make sure giveChange is working properly
     * @throws ChangeException
     */
    @Test
    void giveChange() throws ChangeException {
        // Make sure paymentCollected and totalTransaction are 0
        assertEquals(0.0, register.getPaymentCollected(), EPSILON);
        assertEquals(0.0, register.getTransactionTotal(), EPSILON);

        register.scanItem(4.00);
        register.scanItem(5.62);

        register.collectPayment(Money.DOLLAR, 10);

        // Change should be 0.32
        assertEquals(0.38, register.giveChange(), EPSILON);
    }

    /**
     * A test to make sure exceptions are thrown when we expect them to, and
     * NOT thrown when everything is OK
     */
    @Test
    void giveChangeException() {
        register.scanItem(4.00);
        register.scanItem(5.62);

        // Scan for unfinished transaction
        register.collectPayment(Money.DOLLAR, 8);
        assertThrows(ChangeException.class, () -> register.giveChange());
    }
}