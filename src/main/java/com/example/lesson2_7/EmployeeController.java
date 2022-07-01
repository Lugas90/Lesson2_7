package com.example.lesson2_7;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(path = "/all")
    public Map<Integer, Employee> getAll() {
        return employeeService.getAll();
    }

    @RequestMapping("/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("passport") Integer passport) {
        return employeeService.addEmployee(firstName, lastName, passport);
    }

    @RequestMapping("/remove")
    public Employee deleteEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName,
                                   @RequestParam("passport") Integer passport) {
        return employeeService.deleteEmployee(firstName, lastName, passport);
    }

    @RequestMapping("/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName,
                                 @RequestParam("passport") Integer passport) {
        return employeeService.findEmployee(firstName, lastName, passport);
    }
}
