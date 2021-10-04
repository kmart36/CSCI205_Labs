/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2021
 *
 * Name: Katy Martinson and Phil Morgan
 * Date: 10/01/19
 * Time: 1:45 PM
 *
 * Project: csci205_labs
 * Package: lab06
 * Class: HRDBSystem
 * Description:
 * A HRDBSystem class that creates Employees and Managers and organizes
 * them into their department.
 * ****************************************
 */

package lab06;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HRDBSystem {
    public static void main(String[] args) throws ParseException, ManagerException {

        ArrayList<Employee> empList = new ArrayList<>();
        ArrayList<Manager> mgrList = new ArrayList<>();
        mgrList.add(new Manager(0, "Pat", "Mather", 101010101,
                                HRDateUtils.strToDate("2015-07-15"), 125000, "ENGINEERING"));
        empList.add(mgrList.get(0));
        empList.add(new Employee(1, "Brian", "King", 123456789,
                                 HRDateUtils.strToDate("2010-08-20"), 60000));
        empList.add(new Employee(2, "Chris", "Dancy", 402040302,
                                 HRDateUtils.strToDate("2015-07-02"), 65000));
        empList.add(new Employee(200, "Florence", "Machine", 149285729,
                                 HRDateUtils.strToDate("2014-12-01"), 62500));

        mgrList.add(new Manager(-1, "John", "Bravman", 121230103,
                                HRDateUtils.strToDate("2010-02-19"), 250000, "ADMIN"));
        empList.add(mgrList.get(1));

        empList.add(new Employee(10, "Bonnie", "Raitt", 849324810, HRDateUtils.strToDate("2003-07-20"), 150000));
        empList.add(new Employee(10, "Robert", "Randolph", 121212121, LocalDate.now(), 145000));
        empList.add(new Employee(2, "Jimi", "Hendrix", 000000001, LocalDate.now(), 250000));
        empList.add(new Employee(201, "Nancy", "Wilson", 111111111,
                                 HRDateUtils.strToDate("1989-02-10"), 60000));

        mgrList.get(0).addEmployee(empList.get(1));
        mgrList.get(0).addEmployee(empList.get(2));
        mgrList.get(0).addEmployee(empList.get(3));
        mgrList.get(1).addEmployee(empList.get(5));
        mgrList.get(1).addEmployee(empList.get(6));
        mgrList.get(1).addEmployee(empList.get(7));
        mgrList.get(1).addEmployee(empList.get(8));


        // Printing one
        System.out.println(empList.get(0));

        // Using our utility
        displayEmployee(empList.get(0));

        System.out.println("*** Our complete list ***");
        displayEmployees(empList);

        System.out.println("*** A manager example ***");
        displayManager(mgrList.get(0));

    }

    public static void displayEmployee(Employee emp) {
        System.out.printf("%4d: %s %s", emp.getEmpID(), emp.getFirstName(),
                          emp.getLastName());
        if (emp instanceof Manager) {
            System.out.print(" [MANAGER]");
        }
        System.out.println();
    }

    public static void displayEmployees(List<Employee> listOfEmps) {
        for (Employee emp : listOfEmps) {
            displayEmployee(emp);
        }
    }

    /**
     * Helper method to print out details of a Manager, including a list
     * of employees the manager manages.
     *
     * @param mgr The Manager who is being displayed
     */
    public static void displayManager(Manager mgr) {
        System.out.printf("Manager:     %s %s\n", mgr.getFirstName(),
                          mgr.getLastName());
        System.out.printf("Department:  %s\n", mgr.getDeptName());
        System.out.printf("# Employees: %d\n", mgr.getEmpList().size());
        displayEmployees(mgr.getEmpList());
    }


}
