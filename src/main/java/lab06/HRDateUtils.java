/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2021
 *
 * Name: Katy Martinson and Phil Morgan
 * Date: 10/01/21
 * Time: 1:47 PM
 *
 * Project: csci205_labs
 * Package: lab06
 * Class: HRDateUtils
 * Description:
 * A utility class to prepare dates easily
 * ****************************************
 */

package lab06;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * A utility class to encapsulate the date formatting functionality
 */
public final class HRDateUtils {

    // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/time/format/DateTimeFormatter.html
    private static DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * Helper method to parse a date string into a date object. This is
     * really here just to show how to deal with an exception that may
     * be thrown in a method.
     *
     * @param sDate - a date string
     * @return a {@link LocalDate} object
     * @throws {@link DateTimeParseException} if the string cannot be parsed correctly.
     */
    public static LocalDate strToDate(String sDate) throws DateTimeParseException {
        return LocalDate.parse(sDate,df);
    }

    /**
     * Helper method to convert a date object to a {@link LocalDate} string.
     */
    static String dateToStr(LocalDate date) {
        return df.format(date);
    }
}
