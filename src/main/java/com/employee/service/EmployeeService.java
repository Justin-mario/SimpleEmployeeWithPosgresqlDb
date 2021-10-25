package com.employee.service;

import com.employee.data.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    void saveEmployee(Employee newEmployee);
    List<Employee> getEmployee();
    void deleteEmployee(Long id);
    Employee getEmployeeById(Long id);
    void replaceEmployee(Employee newEmployee, Long id);
}
