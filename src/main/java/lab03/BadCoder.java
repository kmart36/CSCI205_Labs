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
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Greetings. What is your name?");
        String name = scnr.next();

        Random rand = new Random();
        int[] x = new int[10];
        for (int i = 0; i < 10; i++) {
            x[i] = rand.nextInt(100);
        }
        System.out.println(name + ", our array is: " + Arrays.toString(x));
    }
}