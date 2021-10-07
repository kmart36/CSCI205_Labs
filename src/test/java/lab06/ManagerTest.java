package lab06;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    private Manager mgr;
    private Employee emp1;
    private Employee emp2;

    @BeforeEach
    void setUp() {
        mgr = new Manager(1, "Erin", "Jablonski", 123456789, HRDateUtils.strToDate("2021-07-15"),
                100000.0, "ENGINEERING");
        emp1 = new Employee(1, "Brian", "King", 123456789, HRDateUtils.strToDate("2010-08-20"), 60000);
        emp2 = new Employee(2, "Chris", "Dancy", 402040302, HRDateUtils.strToDate("2015-07-02"), 65000);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addEmployee() throws ManagerException {
        mgr.addEmployee(emp1);
        mgr.addEmployee(emp2);
        assertEquals(emp1, mgr.getEmpList().get(0));
        assertEquals(emp2, mgr.getEmpList().get(1));
    }

    @Test
    void addEmployeeException() throws ManagerException {
        mgr.addEmployee(emp1);
        // Add the same employee into the list
        assertThrows(ManagerException.class, () -> mgr.addEmployee(emp1));
    }

    @Test
    void removeEmployee() throws ManagerException {
        mgr.addEmployee(emp1);
        mgr.addEmployee(emp2);
        mgr.removeEmployee(emp1);
        assertEquals(emp2, mgr.getEmpList().get(0));
    }

    @Test
    void removeEmployeeException() {
        assertThrows(ManagerException.class, () -> mgr.removeEmployee(emp1));
    }
}