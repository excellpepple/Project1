/*
* @auth: Excellent Willie-Pepple
* @date: 2/7/2023
* @description: The Employee Class Manages the information needed to manage and track employees
* */
import java.io.FileNotFoundException;

public class Project1 {
    public static void main(String[] args) {
        EmployeeMap empMap = new EmployeeMap(200);
        EmployeeDictionary empDictionary = new EmployeeDictionary(200);
        FileIO fr = new FileIO(empMap, empDictionary);
        try {
            fr.readRecord("empRecord.dat");
            empDictionary.insert(new Employee("Willie-Pepple",
                    "Excellent",
                    "Project Manager",
                    9138.0, "PM2323"), 25);
            empDictionary.insert(new Employee("Waller", "Amanda", "Human Resource", 200.0, "HR2762"), 24);

            fr.writeEmployeeMap("empMap.out");
            fr.writeEmployeeRecord("empRecord.out");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
