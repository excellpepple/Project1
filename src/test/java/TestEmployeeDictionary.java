/*
* @auth: Excellent Willie-Pepple
* @date: 2/7/2023
* @description: The Employee Class Manages the information needed to manage and track employees
* */
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestEmployeeDictionary {
    private EmployeeDictionary empDict;
    private Employee employee1, employee2, employee3;

    @BeforeEach
    void setUp() {
        empDict = new EmployeeDictionary(3);
        employee1 = new Employee("LastName", "FirstName", "Programmer", 120.0, "P1235");
        employee2 = new Employee("LastName1", "FirstName1", "Accounting", 121, "P1236");
        employee3 = new Employee("LastName2", "FirstName2", "Writer", 122.0, "P1237");
    }


    @Test
    void insert() {
        boolean actual = empDict.insert(employee1, 0);
        assertTrue(actual);
    }

    @Test
    void remove() {
        empDict.insert(employee2, 1);
        assertTrue(empDict.remove(1));
    }

    @Test
    void firstVacant() {
        empDict.insert(employee1, 0);
        empDict.insert(employee2, 1);
        empDict.insert(employee3, 2);
        assertEquals(-1, empDict.firstVacant());
    }

    @Test
    void isPresent() {
        empDict.insert(employee1, 0);
        empDict.insert(employee2, 1);
        empDict.insert(employee3, 2);
        assertTrue(empDict.isPresent(0));
    }

    @Test
    void getEmployeeRecords() {
        empDict.insert(employee1, 0);
        empDict.insert(employee2, 1);
        empDict.insert(employee3, 2);
        assertEquals(empDict.getEmployeeRecords(0), employee1);
    }
}