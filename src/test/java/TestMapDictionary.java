/*
* @auth: Excellent Willie-Pepple
* @date: 2/7/2023
* @description: The Employee Class Manages the information needed to manage and track employees
* */
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TestMapDictionary {
    private EmployeeMap employeeMap;
    private Employee employee1, employee2, employee3;

    @BeforeEach
    void setUp() {
        employeeMap = new EmployeeMap(3);
        employee1 = new Employee("LastName", "FirstName", "Programmer", 120.0, "P1235");
        employee2 = new Employee("LastName1", "FirstName1", "Accounting", 121, "P1236");
        employee3 = new Employee("LastName2", "FirstName2", "Programmer", 122.0, "P1237");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void insert() {
        int expected = employeeMap.insert(employee1);
        assertTrue(expected != -1);
    }

    @Test
    void remove() {
        employeeMap.insert(employee1);
        employeeMap.remove(employee1.getEmp_id());
        assertEquals(-1, employeeMap.findIndex(employee1.getEmp_id()));
    }

    @Test
    void findIndex() {
        employeeMap.insert(employee1);
        employeeMap.insert(employee2);
        assertEquals(0, employeeMap.findIndex(employee1.getEmp_id()));
        assertEquals(1, employeeMap.findIndex(employee2.getEmp_id()));
        assertEquals(-1, employeeMap.findIndex(employee3.getEmp_id()));
    }

    @Test
    void searchPosition() {
        employeeMap.insert(employee1);
        employeeMap.insert(employee2);
        employeeMap.insert(employee3);
        int[] expected = {0, 2};
        assertArrayEquals(expected, employeeMap.searchPosition('P'));
    }


}
