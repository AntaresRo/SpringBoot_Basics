package com.springboot.demo.myapp.service;

import com.springboot.demo.myapp.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findByID(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int thisId);
}
