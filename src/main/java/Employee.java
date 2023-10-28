/*
* @auth: Excellent Willie-Pepple
* @date: 2/7/2023
* @description: The Employee Class Manages the information needed to manage and track employees
* */
import java.util.Random;

public class Employee implements Cloneable {

    private static int COUNTER = 0;
    private String emp_id;
    private String last_name;
    private String first_name;
    private String position;
    private double salary;

    // A constructor.
    public Employee(
            String last_name,
            String first_name,
            String position,
            double salary,
            String emp_id) {
        setFirst_name(first_name);
        setLast_name(last_name);
        setSalary(salary);
        setPosition(position);
        setEmp_id(emp_id);
        COUNTER++;
    }


    // A copy constructor.
    public Employee(Employee e){
        setFirst_name(e.getFirst_name());
        setLast_name(e.getLast_name());
        setSalary(e.getSalary());
        setPosition(e.getPosition());
        setEmp_id(e.getEmp_id());
        COUNTER++;
    }

    /**
     * This function returns a copy of the first_name field.
     *
     * @return A new String object is being returned.
     */
    public String getFirst_name() {
        return new String(first_name);
    }

    /**
     * This function sets the first_name variable to the value of the first_name parameter.
     *
     * @param first_name The first name of the user.
     */
    public void setFirst_name(String first_name) {
        this.first_name = new String(first_name);
    }

    /**
     * The function returns a new String object that is a copy of the emp_id field
     *
     * @return A new String object is being returned.
     */
    public String getEmp_id() {
        return new String(emp_id);
    }

    /**
     * This function sets the value of the emp_id variable to the value of the id variable.
     *
     * @param id The id of the employee
     */
    public void setEmp_id(String id) {
        emp_id = new String(id);
    }


    /**
     * This function returns a copy of the last_name field.
     *
     * @return A new String object is being returned.
     */
    public String getLast_name() {
        return new String(last_name);
    }

    /**
     * This function sets the last name of the user to the value of the last_name parameter.
     *
     * @param last_name The last name of the user.
     */
    public void setLast_name(String last_name) {
        this.last_name = new String(last_name);
    }

    /**
     * This function returns a copy of the position string.
     *
     * @return A new String object is being returned.
     */
    public String getPosition() {
        return new String(position);
    }

    /**
     * This function sets the position of the player.
     *
     * @param position The position of the player.
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * This function returns the salary of the employee.
     *
     * @return The salary of the employee.
     */
    public double getSalary() {
        return salary;
    }

    /**
     * This function sets the salary of the employee to the value of the salary parameter.
     *
     * @param salary The salary of the employee.
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * The function first calls the superclass's clone method, which returns a reference to an object of type Object. The
     * function then casts the reference to the correct type and assigns it to a variable of type Employee
     *
     * @return A clone of the object
     */
    protected Employee clone() throws CloneNotSupportedException {
        Employee ans;
        try {
            clone();
            ans = (Employee) super.clone();

        } catch (CloneNotSupportedException e){
            throw new CloneNotSupportedException("Not cloning");
        }
        return ans;
    }

    /**
     * The toString() method returns a string representation of the object
     *
     * @return The employee's ID, last name, first name, position, and salary.
     */
    @Override
    public String toString() {
        return emp_id + "\t\t" + last_name + "\t" + first_name + "\t\t" + position + "\t\t" + salary;
    }


    /**
     * If the employee id, position, first name, last name, and salary are all the same, then the two employees are equal
     *
     * @param emp The employee object to compare to
     * @return A boolean value.
     */
    public boolean equals(Employee emp) {
        boolean result = emp.getEmp_id() == this.getEmp_id() ||
                emp.getPosition() == this.getPosition() ||
                emp.getFirst_name() == this.getFirst_name()
                || emp.getLast_name() == this.getLast_name() ||
                emp.getSalary() == this.getSalary();


        return result;
    }
}
