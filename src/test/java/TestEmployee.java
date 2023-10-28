/*
* @auth: Excellent Willie-Pepple
* @date: 2/7/2023
* @description: The Employee Class Manages the information needed to manage and track employees
* */
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestEmployee {
    public static Employee employee;
    private String expected;
    private String actual;
    @BeforeEach
    void setUp() {
        employee = new Employee("LastName", "FirstName", "Programmer", 120.0, "P1235");
    }

    @Test
    void getFirst_name() {
        String expected = "FirstName";
        actual = employee.getFirst_name();
        assertEquals(expected, actual);
    }

    @Test
    void setFirst_name() {
        String expected = "FirstName1";
        employee.setFirst_name(expected);
       actual = employee.getFirst_name();
        assertEquals(expected, actual);
    }

    @Test
    void getEmp_id() {
        expected = "P1235";
        actual = employee.getEmp_id();
        assertEquals(expected, actual);
    }

    @Test
    void setEmp_id() {
        expected = "P1236";
        employee.setEmp_id(expected);
        actual = employee.getEmp_id();
        assertEquals(expected, actual);
    }

    @Test
    void getLast_name() {
        expected = "LastName";
        actual = employee.getLast_name();
        assertEquals(expected, actual);
    }

    @Test
    void setLast_name() {
        actual = "LastName1";
        employee.setLast_name(actual);
        expected = employee.getLast_name();
        assertEquals(expected, actual);
    }

    @Test
    void getPosition() {
        actual = "Programmer";
        expected = employee.getPosition();
        assertEquals(expected, actual);
    }

    @Test
    void setPosition() {
        expected = "Director";
        employee.setPosition(expected);
        actual = employee.getPosition();
        assertEquals(expected, actual);
    }

    @Test
    void getSalary() {
        expected = "120.0";
        actual = ""+employee.getSalary();
        assertEquals(expected, actual);
    }

    @Test
    void setSalary() {
        expected = "121.0";
        employee.setSalary(Double.parseDouble(expected));
        actual = ""+employee.getSalary();
        assertEquals(expected, actual);
    }

    @Test
    void testClone() {
        Employee newEmp;
        try {
            newEmp = (Employee) employee.clone();
            assertTrue(newEmp.equals(employee));
        } catch (CloneNotSupportedException e) {
            assertFalse(true);
        }
    }
}