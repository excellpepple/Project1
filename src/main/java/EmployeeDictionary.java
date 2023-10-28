/*
* @auth: Excellent Willie-Pepple
* @date: 2/7/2023
* @description: The Employee Class Manages the information needed to manage and track employees
* */
public class EmployeeDictionary {
    private Employee[] employeeRecords;

    // The constructor for the EmployeeDictionary class. It is checking to make sure that the size is between 1 and 200. If
    // it is not, it throws an IllegalArgumentException. If it is, it creates a new Employee array of the size specified.
    //@pre-condition: the size must be between 1 and 200
    //@post-condition: a new employee array is created
    public EmployeeDictionary(int size){
        if (size < 1) throw new IllegalArgumentException("size must be greater than 1");
        if (size > 200) throw new IllegalArgumentException("size must be less than 200");
        else{
            employeeRecords = new Employee[size];
        }
    }

    /**
     * Inserts an employee into the employeeRecords array at the specified index, and returns true if the insertion was
     * successful.
     *
     * @param employee The employee to be inserted into the array
     * @param index The index of the array where the employee will be inserted.
     * @return A boolean value
     * @pre-condition An employee must be passed in to the method, and a valid index must be in the range of [1, 200]
     * @post-condition If the employee was inserted, the method will return true
     */
    public boolean insert(Employee employee, int index){
        if (index < 0 || index >= employeeRecords.length) throw new IllegalArgumentException("index must be in the range [0, 200]");
        if (employee == null) throw new IllegalArgumentException("There must be an employee for there to be an insertion");
        employeeRecords[index] = employee;
        return true;
    }

    /**
     * If the index is valid and the employee is present, remove the employee
     *
     * @param index The index of the employee record to remove.
     * @return A boolean value.
     * @pre-condition The index  must be in the range of [1, 200]
     * @post-condition if the index is valid the method will return true
     */
    public boolean remove(int index){
        if (index < 0 || index >= employeeRecords.length) throw new IllegalArgumentException("index must be in the range [0, 200]");
        if (isPresent(index)){
            employeeRecords[index] = null;
        }
        return true;
    }

    /**
     * Return the index of the first vacant spot in the array, or -1 if there are no vacant spots.
     *
     * @return The index of the first vacant position in the array.
     */
    public int firstVacant(){
        int i = 0;
        for (Employee employee : employeeRecords){
            if (employee == null){
                return i;
            }
            i++;
        }
        return -1;
    }

    /**
     * If the index is out of bounds, throw an IllegalArgumentException, otherwise return true if the employee record is
     * null, false otherwise.
     *
     * @param index the index of the employee record to check
     * @return The method is returning a boolean value.
     * @pre-condition The index passed must be within the range of the [1, 200]
     * @post-condition The method is returning a boolean value if the index passed is valid
     */
    public boolean isPresent(int index){
        if ( index < 0 || index >= employeeRecords.length) throw new IllegalArgumentException("index must be in the range [0, 200]");
        return employeeRecords[index] == null;
    }

    /**
     * The function creates a new EmployeeDictionary object, and then copies the employeeRecords array from the original
     * object to the new object
     *
     * @return A clone of the EmployeeDictionary object.
     */
    @Override
    protected EmployeeDictionary clone() throws CloneNotSupportedException {
        EmployeeDictionary ans;
        try {
            clone();
            ans = (EmployeeDictionary) super.clone();
            ans.employeeRecords = (Employee[]) employeeRecords.clone();
        } catch (CloneNotSupportedException e){
            throw new CloneNotSupportedException("Not cloning");
        }
        return ans;
    }

    /**
     * The function loops through the array and adds each employee to a string, which is then returned
     *
     * @return The employeeRecords array is being returned.
     */
    @Override
    public String toString() {
        String output = "";

        for (int i = 0; i < employeeRecords.length; i++){
            if (employeeRecords[i] != null){
                output += employeeRecords[i] + "\n";
            }
        }
        return output;
    }

    /**
     * This function returns the employee record at the given index.
     *
     * @param index The index of the employee record to be retrieved.
     * @return The employee record at the index.
     * @pre-condition The index of the employee record to be retrieved must be in the range [1, 100]
     * @post-condition The method returns the employee record at the given index.
     */
    public Employee getEmployeeRecords(int index) {
        if (index < 0 || index >= 200) throw new IllegalArgumentException("Index must be in the range of [1, 200]");
        return employeeRecords[index];
    }
}
