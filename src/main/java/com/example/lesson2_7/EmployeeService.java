package com.example.lesson2_7;

import com.example.lesson2_7.exceptions.EmployeeAlreadyAddedException;
import com.example.lesson2_7.exceptions.EmployeeNotFoundException;
import com.example.lesson2_7.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {
    private final int LIMIT = 10;
    private static Map<Integer, Employee> emp1 = new HashMap<>();

    public Employee addEmployee(String firstName, String lastName, Integer passport) {
        Employee emp = new Employee(firstName, lastName, passport);
        if (emp1.containsKey(passport)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (emp1.size() < LIMIT) {
            emp1.put(emp.getPassport(), emp);
            return emp;
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee deleteEmployee(String firstName, String lastName, Integer passport) {
        Employee emp = new Employee(firstName, lastName, passport);
        if (!emp1.containsKey(emp.getPassport())) {
            throw new EmployeeNotFoundException();
        }
        emp1.remove(emp);
        return emp;
    }

    public Employee findEmployee(String firstName, String lastName, Integer passport) {
        Employee emp = new Employee(firstName, lastName,passport);
        if (emp1 == null){
            throw new EmployeeNotFoundException();
        }
        return emp;
    }
    public Map <Integer, Employee> getAll (){
        return new HashMap<> (emp1);
    }
}
