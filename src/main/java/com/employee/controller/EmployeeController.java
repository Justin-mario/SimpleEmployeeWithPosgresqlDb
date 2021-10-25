package com.employee.controller;

import com.employee.data.model.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){
        return employeeService.getEmployee ();
    }

    @GetMapping ("/employees/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById ( id );
    }

    @PostMapping("/employees")
    public  void saveEmployee(@RequestBody Employee newEmployee){
        employeeService.saveEmployee ( newEmployee );
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee ( id );
    }

    @PutMapping("/employees/{id}")
    public void changeEmployee(@RequestBody Employee newEmployee, @PathVariable Long id){
         employeeService.replaceEmployee ( newEmployee, id );
    }
}
