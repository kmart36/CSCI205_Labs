/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2021
 * Instructor: Prof. Brian King
 *
 * Name: Katy Martinson
 * Section: 9:30am
 * Date: 9/10/2021
 * Time: 6:06 PM
 *
 * Project: csci205_labs
 * Package: lab02
 * Class: BinaryConverter
 *
 * Description:
 * A program that asks the user for a binary number and converts
 * it to its decimal equivalent.
 * ****************************************
 */
package lab02;

import java.util.Scanner;
/**
 * A program that allows us to convert a binary number to a decimal number.
 *
 * @author Katy Martinson
 *
 * @version Java 11
 */
public class BinaryConverter {

    /**
     * Main method that asks the user to input a binary number and completes the necessary calculations.
     *
     * @param args - arguments passed by the user
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.print("Welcome to the binary converter.\n");
        String doContinue = "Y";
        while (doContinue.equals("Y") || doContinue.equals("y")) {
            System.out.print("Enter a binary number: ");
            String strBinary = scnr.next();
            if (!checkIfBinary(strBinary)) {
                System.out.print("ERROR! Try again. ");
            }
            else {
                System.out.println("" + convertBinToDec(strBinary));
                System.out.print("Try again? [Y|N] ");
                doContinue = scnr.next();
            }
        }
        System.out.println("Goodbye.");
    }

    /**
     * Method that takes in a binary string and processes it into a decimal number. Returns the decimal number.
     *
     * @param binary - A binary string only consisting of '0' or '1'.
     * @return numDecimal - The converted binary to decimal number.
     */
    public static int convertBinToDec(String binary){
        int numDecimal = 0;
        double pow = 0.0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            char workingChar = binary.charAt(i);
            numDecimal += Character.getNumericValue(workingChar) * Math.pow(2.0, pow);
            pow++;
        }
        return numDecimal;
    }

    /**
     * Tests to see if the entered string is a binary number, i.e. only has '1' and '0' characters.
     *
     * @param binaryTest - String to be tested, unknown if it contains just '1' and '0' or if it contains other numbers/characters.
     * @return - Returns true if the entered string is a binary number, false otherwise.
     */
    public static boolean checkIfBinary(String binaryTest) {
        return binaryTest.matches("^[01]*$");
    }
}