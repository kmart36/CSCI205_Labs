/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2021
 * Instructor: Prof. Brian King
 *
 * Name: Katy Martinson and Phil Morgan
 * Section: 9:30am
 * Date: 9/15/2021
 * Time: 9:32 AM
 *
 * Project: csci205_labs
 * Package: lab03
 * Class: BadCoder
 *
 * Description:
 *
 * ****************************************
 */
package lab03;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class BadCoder {

    public static final int NUM_INTS = 10;
    public static final int MAX_RANDOM_INT = 100;

    public static void main(String[] args) {
        String name = greetUser();

        int[] x = getArrayOfRandomInts(MAX_RANDOM_INT);
        System.out.println(name + ", our array is: " + Arrays.toString(x));
    }

    /**
     * Fills an array of size NUM_INTS with random numbers between 0 and 99 inclusive.
     *
     * @param bound - Maximum random number not inclusive (Between 0 and bound - 1)
     *
     * @return x - Array of random ints size of NUM_INTS
     */
    private static int[] getArrayOfRandomInts(int bound) {
        //Some simple code to test the debugger
        Random rand = new Random();
        int[] x = new int[NUM_INTS];
        for (int i = 0; i < NUM_INTS; i++) {
            x[i] = rand.nextInt(bound);
        }
        return x;
    }

    /**
     * Asks the user for their name and returns the String input.
     *
     * @return name - Name of the user after input
     */
    private static String greetUser() {
        //Greet the user and ask for their name
        Scanner scnr = new Scanner(System.in);
        System.out.println("Greetings. What is your name?");
        String name = scnr.next();
        return name;
    }
}