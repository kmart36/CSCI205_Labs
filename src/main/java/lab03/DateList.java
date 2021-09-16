/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2021
 * Instructor: Prof. Brian King
 *
 * Name: Katy Martinson
 * Section: 9:30am
 * Date: 9/15/2021
 * Time: 11:18 AM
 *
 * Project: csci205_labs
 * Package: lab03
 * Class: DateList
 *
 * Description:
 *
 * ****************************************
 */
package lab03;

import com.sun.javafx.collections.ArrayListenerHelper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

public class DateList {
    private ArrayList<LocalDate> dates;

    /**
     * Constructor for the DateList class
     * instantiates dates as a new arrayList
     */
    public DateList() {
        dates = new ArrayList<>();
    }

    /**
     * returns the String representation of the arrayList
     *
     * @return the string representation of the arrayList
     */
    public String toString() {
        int i = 0;
        int testPos;

        String output = "DateList{dates=[";
        while (i < dates.size()) {
            output += dates.get(i);
            testPos = i;
            if (testPos++ != dates.size()-1) {
                output += ", ";
            }
            i++;
        }
        output += "]}";
        return output;
    }

    /**
     * adds a String representation of a date to the arrayList
     *
     * @param date a string that represents a date
     */
    public void addDate(String date) {
        dates.add(LocalDate.parse(date));
    }

    /**
     * adds a LocalDate representation of a date to the arrayList
     *
     * @param date a LocalDate that represents a date
     */
    public void addDate(LocalDate date) {
        dates.add(date);
    }

    /**\
     * returns the size of the arrayList
     *
     * @return an int that represents the size of the arrayList
     */
    public int size() {
        return dates.size();
    }

    /**
     * sorts the arrayList and returns it
     *
     * @return a sorted arrayList of dates
     */
    public ArrayList<LocalDate> sort() {
        Collections.sort(dates);
        return dates;
    }

    /**
     * returns true or false after checking if the arrayList contains d
     *
     * @param d a date represented by a LocalDate object
     * @return true or false depending on if the arrayList contains d
     */
    public boolean has(LocalDate d) {
        return dates.contains(d);
    }

    /**
     * returns true or false after checking if the arrayList contains date
     *
     * @param date a date represented by a String
     * @return true or false depending on if the arrayList contains date
     */
    public boolean has(String date) {
        return dates.contains(LocalDate.parse(date));
    }


    /**
     * returns the arrayList object dates
     *
     * @return the arrayList object dates
     */
    public ArrayList<LocalDate> getList() {
        return dates;
    }


    /**
     * Returns the stream representation of the date list
     *
     * @return the stream representation of the date list
     */
    public Stream<LocalDate> getStream() {
        return this.dates.stream();
    }
}