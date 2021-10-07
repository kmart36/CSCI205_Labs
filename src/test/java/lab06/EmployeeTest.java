package lab06;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testIDFactory() {
        Employee emp1 = new Employee(100, "A", "B", 100000000, LocalDate.now(), 10000);
        Employee emp2 = new Employee(100, "A", "B", 100000000, LocalDate.now(), 10000);
        Employee emp3 = new Employee(-100, "A", "B", 100000000, LocalDate.now(), 10000);
        assertEquals(100, emp1.getEmpID());
        assertEquals(1, emp2.getEmpID());
        assertEquals(2, emp3.getEmpID());
    }

    @Test
    void testChangeName() {
        Employee emp1 = new Employee(5, "A", "B", 100000000, LocalDate.now(), 10000);

        emp1.changeName("Y", "Z");

        assertEquals("Y", emp1.getFirstName());
        assertEquals("Z", emp1.getLastName());
    }

    @Test
    void testRaiseSalary() {
        Employee emp1 = new Employee(5, "A", "B", 100000000, LocalDate.now(), 10000);

        emp1.raiseSalary(5000);
        assertEquals(15000, emp1.getSalary());
    }

    @Test
    void testEquals() {
        //Both ssNums are the same
        Employee emp1 = new Employee(5, "A", "B", 100000000, LocalDate.now(), 10000);
        Employee emp2 = new Employee(5, "A", "B", 100000000, LocalDate.now(), 10000);
        boolean what = emp1 == emp2;
        assertEquals(true, emp1.equals(emp2));
    }
}