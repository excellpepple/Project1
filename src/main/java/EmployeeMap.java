/*
* @auth: Excellent Willie-Pepple
* @date: 2/7/2023
* @description: The Employee Class Manages the information needed to manage and track employees
* */
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.regex.Pattern;


public class EmployeeMap implements Cloneable {
    private String[] key; //Employee IDs
    private int[] value; //Employees
    public int ManyItem;
    public EmployeeDictionary empDict;


    // This is the constructor for the EmployeeMap class. It takes in an integer as a parameter and creates an array of
    // that size.
    public EmployeeMap(int numberOfItems){
        if (numberOfItems <= 200 && numberOfItems >0){
            key = new String[numberOfItems];
            value = new int[numberOfItems];
            empDict = new EmployeeDictionary(numberOfItems);
            ManyItem = 0;
        } else{
            throw new IllegalArgumentException("Number of items must be less than or equal to 200 and greater than 0");
        }
    }


    /**
     * If the employee is not in the dictionary, insert it into the dictionary and return 1. If the employee is already in
     * the dictionary, update the employee's information and return 0. If the employee is null, throw an exception
     *
     * @param employee The employee object to be inserted into the dictionary.
     * @return The return value is the number of items inserted.
     */
    public int insert(Employee employee){
        if (employee == null) throw new IllegalArgumentException("Employee must not be null");
        try {
            int target = findIndex(employee.getEmp_id());
            if ( target == -1){
                key[ManyItem] = employee.getEmp_id();
                int openIndex = empDict.firstVacant();
                value[ManyItem] = openIndex;
                empDict.insert(employee, openIndex);
                ManyItem++;
                return 1;
            } else{
                value[target] = target;
                return 0;
            }
        } catch (Exception e){
            return -1;
        }
    }

    /**
     * If the employee ID is not empty, find the index of the employee ID in the array, if the index is not -1, then remove
     * the employee ID from the dictionary, and replace the employee ID with the last employee ID in the array
     *
     * @param EmpID The employee ID of the employee to be removed.
     */
    public void remove(String EmpID){
        if (EmpID.isEmpty() || EmpID.compareToIgnoreCase(" ") == 0) throw new IllegalArgumentException("Employee ID can not be null");
        int target = findIndex(EmpID);
        if (target != -1){
            if(target != ManyItem -1){
                if (empDict.isPresent(target)){
                    empDict.remove(target);
                };
                String tempKey = key[ManyItem-1];
                int tempEmployee = value[ManyItem-1];
                key[target] = new String(tempKey);
                value[target] = tempEmployee;
            }
            ManyItem--;
        }
    }

    /**
     * This function takes in a string and returns an integer
     *
     * @param EmpID The employee ID that you want to find the index of.
     * @return The index of the employee ID.
     */
    public int findIndex(String EmpID){
         if (EmpID.isEmpty() || EmpID.compareToIgnoreCase(" ") == 0) throw new IllegalArgumentException("Employee ID can not be null");
        for (int i = 0; i < ManyItem; i++){
            if(key[i].compareToIgnoreCase(EmpID) == 0){
                return i;
            }
        }
        return -1;
    }

    /**
     * This function will search for the position of the employee and return the index of the employee
     *
     * @param Position The position of the employee.
     * @return The method is returning an array of integers.
     */
    public int[] searchPosition(char Position){
        if (String.valueOf(Position).isEmpty()) throw new IllegalArgumentException("Position can not be empty");
        int[] found = new int[ManyItem];
        int pointer = 0;
        for(int i = 0; i < ManyItem; i++){
            if(empDict.getEmployeeRecords(value[i]).getPosition().charAt(i) == Position){
                found[pointer++] = i;
            }
        }
        return found;
    }

    /**
     * The clone function creates a new EmployeeMap object, and then copies the EmployeeDictionary object from the original
     * EmployeeMap object into the new EmployeeMap object
     *
     * @return A clone of the EmployeeMap object.
     */
    @Override
    protected EmployeeMap clone() throws CloneNotSupportedException {
        EmployeeMap ans;
        try {
            clone();
            ans = (EmployeeMap) super.clone();
            ans.empDict = (EmployeeDictionary) empDict.clone();
        } catch (CloneNotSupportedException e){
            throw new CloneNotSupportedException("Not cloning");
        }
        return ans;
    }

    // This is a method that is overriding the toString method in the Object class. It is returning a string that contains
    // the index and employee ID of each employee in the array.
    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < ManyItem -1; i++) {
            output += "Index: "+ value[i] + "\tEmployee Id: " + key[i] +"\n" ;
        }
        return output;
    }
}
