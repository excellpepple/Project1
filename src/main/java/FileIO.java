/*
* @auth: Excellent Willie-Pepple
* @date: 2/7/2023
* @description: The Employee Class Manages the information needed to manage and track employees
* */
import java.io.*;
import java.util.Scanner;

public class FileIO {
    private static EmployeeMap empMap;
    private static EmployeeDictionary empDict;
    private static PrintWriter writer = null;
    // A constructor that takes in two objects of type EmployeeMap and EmployeeDictionary and assigns them to the class
    // variables empMap and empDict.
    public FileIO(EmployeeMap empMap, EmployeeDictionary empDict){
        FileIO.empMap = empMap;
        FileIO.empDict = empDict;
    }

    /**
     * The function reads a file and creates an employee object for each line in the file
     *
     * @param filename the name of the file to read from
     */
    public void readRecord(String filename) throws FileNotFoundException {
        Scanner sc = null;
        try {
         sc = new Scanner(new File(filename));
         while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] fields = line.split(" ");
            String employeeId = fields[0];
            String lastName = fields[1];
            String firstName = fields[2];
            String position = fields[3];
            double salary = Double.parseDouble(fields[4]);
            Employee tempEmployee = new Employee(firstName, lastName, position, salary, employeeId);
            empMap.insert(tempEmployee);
            empDict.insert(tempEmployee, empDict.firstVacant());

         }
        } finally {
         if (sc != null) {
            sc.close();
         }
        }
    }
    /**
     * It writes the contents of the employee map to a file
     *
     * @param filename The name of the file to write to.
     */
    public void writeEmployeeMap(String filename){
        try {
         writer = new PrintWriter(new FileWriter(filename));
         writer.println(empMap.toString());
        } catch (IOException e) {
          throw new RuntimeException(e);
        } finally {
         if (writer != null) {
            writer.close();
         }
        }
    }
    /**
     * "If the file is not found, throw a runtime exception, otherwise write the employee dictionary to the file."
     *
     * @param filename The name of the file to write to.
     */
    public void writeEmployeeRecord(String filename){

        try {
         writer = new PrintWriter(new FileWriter(filename));
         writer.println(empDict.toString());
        } catch (IOException e) {
          throw new RuntimeException(e);
        } finally {
         if (writer != null) {
            writer.close();
         }
        }
    }

    /**
     * This function takes in an array of integers and a filename, and writes the employee records corresponding to the
     * indices in the array to the file
     *
     * @param all_index an array of all the indexes of the employees in the dictionary
     * @param filename the name of the file to write to
     */
    public void writeEmployeeRecord(int[] all_index, String filename){
        try {
         writer = new PrintWriter(new FileWriter(filename));
         for (Integer index : all_index){
            if (empDict.isPresent(index)){
                writer.println(empDict.getEmployeeRecords(index).toString());
            }
        }

        } catch (IOException e) {
          throw new RuntimeException(e);
        } finally {
         if (writer != null) {
            writer.close();
         }
        }
    }
}
