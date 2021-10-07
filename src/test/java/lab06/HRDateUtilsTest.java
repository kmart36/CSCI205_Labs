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

    @Test
    void dateToStr() {
        String sExpected = "2020-10-01";
        String sActual = HRDateUtils.dateToStr(LocalDate.parse(sExpected));
        assertEquals(sExpected, sActual);
    }

    void strToDate() {
        LocalDate dExpected = LocalDate.parse("2020-10-01");
        LocalDate dActual = HRDateUtils.strToDate("2020-10-01");
        assertEquals(dExpected, dActual);
    }
}