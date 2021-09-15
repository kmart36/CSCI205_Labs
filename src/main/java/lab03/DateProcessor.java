/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2021
 *
 * Name: Katy Martinson and Phil Morgan
 * Date: 9/15/21
 * Time: 12:18 PM
 *
 * Project: csci205_labs
 * Package: lab03
 * Class: DateProcessor
 * Description:
 * To examine and work with the LocalDate and LocalTime classes.
 * ****************************************
 */

package lab03;

import java.sql.SQLOutput;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.Locale;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * DateProcessor is a simple class to help with learning the {@link java.time.LocalDate} and
 * {@link java.time.LocalTime} classes
 */
public class DateProcessor {

    /**
     * The main program. It presents the user with a menu, asks them for a choice
     * and carries out the appropriate choice.
     *
     * @param args - command line arguments. Not used.
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Welcome to the LocalDate processor");

        // This main method will step through each required task of this lab exercise
        int choice = -1;
        boolean isDone = false;

        do {
            displayMenu();
            choice = getUserChoice(scnr);
            switch(choice) {
                case 1:
                    task1(scnr);
                    break;
                case 2:
                    task2(scnr);
                    break;
                case 3:
                    task3(scnr);
                    break;
                case 4:
                    isDone = true;
                    break;
                default:
                    System.out.println("Bad choice! Try again");
            }
        } while (!isDone);
        System.exit(0);
    }

    /**
     * Show a menu to the user prompting them with the user choices
     */
    private static void displayMenu() {
        System.out.println("Please choose: ");
        System.out.println("  1) Print today's date nicely formatted");
        System.out.println("  2) My feelings on today");
        System.out.println("  3) How long have you been alive? ");
        System.out.println("  4) EXIT");
    }

    /**
     * Read the choice from the user until they guess a correct choice
     *
     * @param scnr - Scanner to read user input from
     * @return the user choice as an integer
     */
    private static int getUserChoice(Scanner scnr) {
        int choice = 0;

        // Show the user the main menu
        boolean isValidChoice = false;
        while (!isValidChoice) {
            String sInput = scnr.nextLine().strip();
            if (sInput.matches("^[1234]$")) {
                choice = Integer.parseInt(sInput);
                isValidChoice = true;
            }
            else {
                System.out.print("Invalid choice. Try again: ");
            }
        }
        return choice;
    }

    /**
     * Solution for task 1
     *
     * @param scnr - The Scanner object to use to read user input
     */
    private static void task1(Scanner scnr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu LLL dd, EEEE");
        LocalDate dateNow = LocalDate.now();
        Locale locale = new Locale("FR");
        System.out.println("Today is " + dateNow);
        System.out.println("Today is " + dateNow.format(formatter));
        System.out.println("Aujourd'hui est " + dateNow.format(formatter.localizedBy(locale)));
    }

    /**
     * Solution for task 2
     *
     * @param scnr - The Scanner object to use to read user input
     */
    private static void task2(Scanner scnr) {
        LocalDate dateNow = LocalDate.now();
        DayOfWeek dayOfWeek = dateNow.getDayOfWeek();
        switch (dayOfWeek) {
            case MONDAY:
                System.out.println("It's Monday. I remember when Minecraft Monday was a thing :(");
                break;
            case TUESDAY:
                System.out.println("IT'S CHEWWWSDAY INNIT?!");
                break;
            case WEDNESDAY:
                System.out.println("It is Wednesday my dudes");
                break;
            case THURSDAY:
                System.out.println("Why is Thursday labelled as 'R' in calendars??");
                break;
            case FRIDAY:
                System.out.println("Friday should be renamed to 'Fryday' and we should get free French fries");
                break;
            case SATURDAY:
                System.out.println("I could go to super on Saturday, but I'm stuck coding");
                break;
            case SUNDAY:
                System.out.println("Lord's day of rest, students' day of work");
                break;
        }
    }

    /**
     * Solution for task 3
     *
     * @param scnr - The Scanner object to use to read user input
     */
    private static void task3(Scanner scnr) {
        LocalDate today = LocalDate.now();
        System.out.println("What day were you born? (Enter as YYYY-MM-DD)");
        String dayBorn = scnr.nextLine();
        int year = Integer.parseInt(dayBorn.substring(0, 4));
        int month = Integer.parseInt(dayBorn.substring(5, 7));
        int day = Integer.parseInt(dayBorn.substring(8, 10));
        LocalDate birthday = LocalDate.of(year, month, day);
        Period p = Period.between(birthday, today);
        long totalDays = ChronoUnit.DAYS.between(birthday, today);
        System.out.println("You are " + p.getYears() + " years, " + p.getMonths() +
                " months, and " + p.getDays() + " days old. In total, you are " + totalDays
                + " days old.");
    }

}
