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
 * Class: Contractor
 *
 * Description:
 * An object representation of a Contractor able to be hired as outside help from a company
 * ****************************************
 */
package lab06;

import java.time.LocalDate;

/**
 * A basic representation for a Contractor
 */
public class Contractor implements Payable {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer ssNum;
    private double hourlyRate;

    /**
     * explicit constructor to create new contractor
     * @param conID     contractor ID
     * @param firstName First name
     * @param lastName  Last name
     * @param ssNum     Social Security Number
     * @param rate      Hourly rate
     */
    public Contractor(int conID, String firstName, String lastName, int ssNum, double rate) {
        this.id = conID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssNum = ssNum;
        this.hourlyRate = rate;
    }

    /**
     * @return Integer, contractor last name
     */
    public Integer getConID() { return this.id; }

    /**
     * @return String, contractor first name
     */
    public String getFirstName() { return firstName; }

    /**
     * @return String, Last name
     */
    public String getLastName() { return lastName; }

    /**
     * @return int, Social Security number
     */
    public int getSsNum() {
        return ssNum;
    }

    /**
     * @return double, current employee salary
     */
    public double getHourlyRate() { return this.hourlyRate; }

    /**
     * @param numHrs double, the number of hours worked
     * @return double, the amount to pay
     */
    @Override
    public double calculatePay(double numHrs) { return numHrs * hourlyRate; }

    /**
     * @return String, the first and last name
     */
    @Override
    public String getPayTo() {
        return this.firstName + " " + this.lastName;
    }

    /**
     * @return String, containing the contractor id and the date of pay
     */
    @Override
    public String getPayMemo() {
        return "Contractor ID: " + this.getConID() + ", Pay Date: " + HRDateUtils.dateToStr(LocalDate.now());
    }

    /**
     * Return a string representation of the Employee
     *
     * @return the String of comma delimited values
     */
    @Override
    public String toString() {
        String s = this.id + "," + this.lastName + "," + this.firstName;
        s += String.format(",%09d", this.ssNum);
        s += String.format(",%.2f", this.hourlyRate);
        return s;
    }
}