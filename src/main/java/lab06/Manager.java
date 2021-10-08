/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2021
 *
 * Name: Katy Martinson and Phil Morgan
 * Date: 9/19/19
 * Time: 1:37 PM
 *
 * Project: csci205_labs
 * Package: lab06
 * Class: Manager
 * Description:
 * A Manager class that extends an Employee interface
 * ****************************************
 */

package lab06;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Checked exception representing any issues that might arise from the Manager
 * class
 */
class ManagerException extends Exception {
    public ManagerException(String message) {
        super(message);
    }
}


public class Manager extends Employee {

    private String deptName;

    private List<Employee> listManagedEmps;

    /**
     * Constructor for the Manager class
     * @param empID int, Manager ID
     * @param firstName String, Manager's first name
     * @param lastName String, Manager's last name
     * @param ssNum int, Manager's social security number
     * @param hireDate LocalDate, the date that the Manager was hired
     * @param salary double, salary of the Manager
     * @param deptName String, name of the department that the Manager works in
     */
    public Manager(int empID, String firstName, String lastName, int ssNum, LocalDate hireDate, double salary, String deptName) {
        super(empID, firstName, lastName, ssNum, hireDate, salary);
        this.deptName = deptName;
        listManagedEmps = new ArrayList<>();
    }

    public List getEmpList() { return this.listManagedEmps; }

    public String getDeptName() { return this.deptName; }

    public void setDeptName(String deptName) { this.deptName = deptName; }

    /**
     * Adds a given employee to the Manager List of this manager
     * @param newEmploy Employee to be added to the Manager List
     * @throws ManagerException Will throw an exception if the employee to be added is already in the Manager List
     */
    public void addEmployee(Employee newEmploy) throws ManagerException{
        if (this.listManagedEmps.contains(newEmploy)) {
            String msg = "Employee is already in list";
            throw new ManagerException(msg);
        }
        this.listManagedEmps.add(newEmploy);
    }

    /**
     * Deletes a given employee from the Manager List of this manager
     * @param deleteEmploy Employee to be deleted from the Manager List
     * @throws ManagerException Will throw an exception if the employee to be deleted is not in the list
     */
    public void removeEmployee(Employee deleteEmploy) throws ManagerException{
        if (!this.listManagedEmps.contains(deleteEmploy)) {
            String msg = "Employee to be removed is not in list";
            throw new ManagerException(msg);
        }
        this.listManagedEmps.remove(deleteEmploy);
    }

    /**
     * @return A string representation of the Manager object
     */
    @Override
    public String toString() {
        return super.toString() + ",MANAGER," + this.deptName;
    }
}
