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

    public Manager(int empID, String firstName, String lastName, int ssNum, LocalDate hireDate, double salary, String deptName) {
        super(empID, firstName, lastName, ssNum, hireDate, salary);
        this.deptName = deptName;
        listManagedEmps = new ArrayList<>();
    }

    public List getEmpList() { return this.listManagedEmps; }

    public String getDeptName() { return this.deptName; }

    public void setDeptName(String deptName) { this.deptName = deptName; }

    public void addEmployee(Employee newEmploy) throws ManagerException{
        if (this.listManagedEmps.contains(newEmploy)) {
            String msg = "Employee is already in list";
            throw new ManagerException(msg);
        }
        this.listManagedEmps.add(newEmploy);
    }

    public void removeEmployee(Employee deleteEmploy) throws ManagerException{
        if (!this.listManagedEmps.contains(deleteEmploy)) {
            String msg = "Employee to be removed is not in list";
            throw new ManagerException(msg);
        }
        this.listManagedEmps.remove(deleteEmploy);
    }

    @Override
    public String toString() {
        return super.toString() + ",MANAGER," + this.deptName;
    }
}
