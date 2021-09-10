/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2021
 * Instructor: Prof. Brian King
 *
 * Name: Katy Martinson
 * Section: 9:30am
 * Date: 9/10/2021
 * Time: 10:40 AM
 *
 * Project: csci205_labs
 * Package: lab02
 * Class: HelloIntelliJ
 *
 * Description:
 *
 * ****************************************
 */
package lab02;
import java.util.Scanner;
/**
 * A simple program to help us become familiar with IntelliJ
 *
 * @author Katy Martinson
 *
 */
public class HelloIntelliJ {

    private static String first;
    private static String last;
    private static String sFullName;

    /**
     * Main method to ask the user for their name and do some basic analysis with it
     *
     * @param args - arguments passed from the command line
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        askUserForName(scnr);

        int vowels = countVowelsInName();
        printResults(vowels);
    }

    /**
     * Print the result of our vowel analysis to {@link System#out}
     *
     * @param vowels is the number of vowels reported
     */
    private static void printResults(int vowels) {
        System.out.printf("You have %d letters in your name\n", first.length() + last.length());
        System.out.printf("You have %d vowels in your name\n", vowels);
        System.out.printf("%.1f%% of your name consists of vowels.", 100.0 * vowels / (sFullName.length() - 1));
    }

    /**
     * Count the vowels in the name that was entered
     *
     * @return the number of vowels in the first and last name
     */
    private static int countVowelsInName() {
        int vowels = 0;
        for (char ch : sFullName.toLowerCase().toCharArray()) {
            switch (ch) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    vowels++;
                    break;
            }
        }
        return vowels;
    }

    /**
     * Ask the user for their first and last name. The results are stored in class
     * variables {@link HelloIntelliJ#first} and {@link HelloIntelliJ#last}. The
     * concatenated names with a space in between will be stores in {@link HelloIntelliJ#sFullName}.
     *
     * @param scnr The scanner object to use to read input from the user.
     */
    private static void askUserForName(Scanner scnr) {
        System.out.print("Please enter your first name: ");
        first = scnr.nextLine().strip();

        System.out.print("Now, enter your last name: ");
        last = scnr.nextLine().strip();

        sFullName = first + " " + last;
        System.out.println("Your full name is : " + sFullName);
    }
}