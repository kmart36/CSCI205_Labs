/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2021
 * Instructor: Prof. Brian King
 *
 * Name: Katy Martinson
 * Section: 9:30am
 * Date: 10/5/2021
 * Time: 11:08 PM
 *
 * Project: csci205_labs
 * Package: lab06
 * Class: Account
 *
 * Description:
 *
 * ****************************************
 */
package lab06;

public class Account{

    private double balance;
    private Payable lastPayee;
    private double lastAmountPaid;

    public Account(double initBalance) {
        this.balance = initBalance;
        this.lastAmountPaid = 0.0;
        this.lastPayee = null;
    }

    public double getBalance() { return this.balance; }

    public void credit(double amount) {
        this.balance += amount;
    }

    public void debit(double amount) throws InsufficientFundsException {
        if (this.balance - amount < 0) {
            String msg = "Cannot withdraw " + amount + " from the account. Available funds: " + this.balance;
            throw new InsufficientFundsException(msg);
        }
        this.balance -= amount;
    }

    public void prepareCheckAndDebit(Payable payee, double hoursBilled) throws InsufficientFundsException {
        double amountToPay = payee.calculatePay(hoursBilled);
        this.debit(amountToPay);
        this.lastPayee = payee;
        this.lastAmountPaid = amountToPay;
    }

    public double getCheckAmount() {
        return this.lastAmountPaid;
    }

    public String writeCheck() {
        if (this.lastAmountPaid == 0.0) { return ""; }
        String s = "Pay to:            " + lastPayee.getPayTo() + "\n" +
                "Pay memo:          " + lastPayee.getPayMemo() + "\n" +
                "Pay amount:        " + this.lastAmountPaid;
        return s;
    }

    @Override
    public String toString() {
        return "" + this.balance;
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}