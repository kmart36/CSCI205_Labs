/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2021
 * Instructor: Prof. Brian King
 *
 * Name: Katy Martinson and Phil Morgan
 * Section: 9:30am
 * Date: 10/5/2021
 * Time: 11:08 PM
 *
 * Project: csci205_labs
 * Package: lab06
 * Class: Account
 *
 * Description:
 * An object representation of a bank account controlled by a company that holds money to pay to Employees, Managers, and Contractors.
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
            String msg = "Cannot withdraw $" + amount;
            msg += String.format(" from the account. Available funds: $%.2f", this.balance);
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
                "Pay memo:          " + lastPayee.getPayMemo() + "\n";
        s += String.format("Pay amount:        $%.2f", this.lastAmountPaid);
        return s;
    }

    @Override
    public String toString() {
        String s = String.format("Account Balance: $%.2f", this.balance);
        return s;
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}