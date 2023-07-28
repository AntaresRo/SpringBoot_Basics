package com.springboot.demo.myapp.service;

import com.springboot.demo.myapp.dao.EmployeeRepo;
import com.springboot.demo.myapp.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee findByID(int theId) {
        Optional<Employee> result = employeeRepo.findById(theId);
        Employee theEmployee = null;
        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            throw new RuntimeException("Employee was not found, with id " + theId);
        }


        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepo.save(theEmployee);
    }

    @Override
    public void deleteById(int thisId) {
        employeeRepo.deleteById(thisId);
    }
}
