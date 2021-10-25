package com.employee.service;

import com.employee.data.model.Employee;
import com.employee.data.repository.EmployeeRepository;
import com.employee.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{


    EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    @Override
    public void saveEmployee(Employee newEmployee) {
        employeeRepository.save ( newEmployee );
    }

    @Override
    public List<Employee> getEmployee() {
        return employeeRepository.findAll ();
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById ( id );
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById ( id ).orElseThrow (()->new EmployeeNotFoundException (id));
    }

    @Override
    public void replaceEmployee(Employee newEmployee, Long id) {
        employeeRepository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return employeeRepository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return employeeRepository.save(newEmployee);
                });

    }
}
