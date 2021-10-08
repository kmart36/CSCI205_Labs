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
 * Class: HRDateUnilsTest
 *
 * Description:
 * A test class for the HRDateUtils class
 * ****************************************
 */

package lab06;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class HRDateUtilsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * A test to ensure the dateToStr method is working properly
     */
    @Test
    void dateToStr() {
        String sExpected = "2020-10-01";
        String sActual = HRDateUtils.dateToStr(LocalDate.parse(sExpected));
        assertEquals(sExpected, sActual);
    }

    /**
     * A test to ensure the strToDate method is working properly
     */
    @Test
    void strToDate() {
        LocalDate dExpected = LocalDate.parse("2020-10-01");
        LocalDate dActual = HRDateUtils.strToDate("2020-10-01");
        assertEquals(dExpected, dActual);
    }
}