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
import java.util.Comparator;
import java.util.List;

public class HRDBSystem {

    private static ArrayList<Employee> empList;
    private static ArrayList<Manager> mgrList;
    private static Contractor c1, c2;
    private static Account acc;

    public static void main(String[] args) throws ParseException, ManagerException {

        // Initializes all employees
        initEmployees();

        // Initializes all managers
        initManagers();

        // Assigns employees to their managers
        assignEmployeesToManagers();

        // Initializes all contractors
        initContractors();

        // Show all of our members we've created
        displayEveryone();

        // Create an account and test it out
        testAccount();

        // Sorting the employee list
        System.out.println("*** Sorting by last name ***");
        empList.sort((emp1, emp2) -> emp1.getLastName().compareToIgnoreCase(emp2.getLastName()));
        displayEmployees(empList);

        System.out.println("*** Sorting by reverse id ***");
        empList.sort((emp1, emp2) -> Integer.compare(emp2.getEmpID(), emp1.getEmpID()));
        displayEmployees(empList);
    }

    /**
     * A method to test an account
     */
    private static void testAccount() {
        acc = new Account(4000.0);
        System.out.println(acc);
        try {
            System.out.println("TEST: Printing a check to employee id: "
                                + empList.get(1).getEmpID());
            // 40 hrs + 10 hrs overtime
            acc.prepareCheckAndDebit(empList.get(1), 50);
            System.out.println(acc.writeCheck());

            System.out.println("TEST: Printing a check to a contractor id: ");
            acc.prepareCheckAndDebit(c1, 35);
            System.out.println(acc.writeCheck());

            System.out.println("TEST: Printing a check to contractor id: " + c2.getConID());
            acc.prepareCheckAndDebit(c1, 35);
            System.out.println(acc.writeCheck());
        }
        catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        //Verify that funds were debited from the account
        System.out.println(acc);
    }

    /**
     * A method to print out every employee and contractor in a user-friendly way
     */
    private static void displayEveryone() {
        System.out.println(empList.get(0));

        // Using our utility
        displayEmployee(empList.get(0));

        System.out.println("*** Our complete list ***");
        displayEmployees(empList);

        System.out.println("*** A manager example ***");
        displayManager(mgrList.get(0));

        System.out.println("*** Contractors ***");
        System.out.println(c1);
        System.out.println(c2);
    }

    /**
     * Instantiates two new contractors
     */
    private static void initContractors() {
        c1 = new Contractor(73, "Builder", "Bob", 342942039, 50.00);
        c2 = new Contractor(69, "cat", "JAM", 696969420, 69.69);
    }

    /**
     * Assigns employees to a manager
     * @throws ManagerException when trying to remove an employee when not in the list, or when trying
     *                          to add an employee who is already in the list
     */
    private static void assignEmployeesToManagers() throws ManagerException {
        mgrList.get(0).addEmployee(empList.get(1));
        mgrList.get(0).addEmployee(empList.get(2));
        mgrList.get(0).addEmployee(empList.get(3));
        mgrList.get(1).addEmployee(empList.get(5));
        mgrList.get(1).addEmployee(empList.get(6));
        mgrList.get(1).addEmployee(empList.get(7));
        mgrList.get(1).addEmployee(empList.get(8));
    }

    /**
     * Initializes all managers
     */
    private static void initManagers() {
        mgrList = new ArrayList<>();
        mgrList.add(new Manager(0, "Pat", "Mather", 101010101,
                HRDateUtils.strToDate("2015-07-15"), 125000, "ENGINEERING"));
        mgrList.add(new Manager(-1, "John", "Bravman", 121230103,
                HRDateUtils.strToDate("2010-02-19"), 250000, "ADMIN"));
        empList.add(0, mgrList.get(0));
        empList.add(4, mgrList.get(1));
    }

    /**
     * Instantiates all employees
     */
    private static void initEmployees() {
        empList = new ArrayList<>();

        empList.add(new Employee(1, "Brian", "King", 123456789,
                                 HRDateUtils.strToDate("2010-08-20"), 60000));
        empList.add(new Employee(2, "Chris", "Dancy", 402040302,
                                 HRDateUtils.strToDate("2015-07-02"), 65000));
        empList.add(new Employee(200, "Florence", "Machine", 149285729,
                                 HRDateUtils.strToDate("2014-12-01"), 62500));
        empList.add(new Employee(10, "Bonnie", "Raitt", 849324810, HRDateUtils.strToDate("2003-07-20"), 150000));
        empList.add(new Employee(10, "Robert", "Randolph", 121212121, LocalDate.now(), 145000));
        empList.add(new Employee(2, "Jimi", "Hendrix", 000000001, LocalDate.now(), 250000));
        empList.add(new Employee(201, "Nancy", "Wilson", 111111111,
                                 HRDateUtils.strToDate("1989-02-10"), 60000));
    }

    public static void displayEmployee(Employee emp) {
        System.out.printf("%4d: %s %s", emp.getEmpID(), emp.getFirstName(),
                          emp.getLastName());
        if (emp instanceof Manager) {
            System.out.print(" [MANAGER]");
        }
        System.out.println();
    }

    /**
     * Prints out the list of employees in a user-friendly way
     * @param listOfEmps The current list of all employees in the system
     */
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


