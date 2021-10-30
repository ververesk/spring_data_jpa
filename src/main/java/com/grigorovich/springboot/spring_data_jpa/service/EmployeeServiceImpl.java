package com.grigorovich.springboot.spring_data_jpa.service;

import com.grigorovich.springboot.spring_data_jpa.dao.EmployeeRepository;
import com.grigorovich.springboot.spring_data_jpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//все методы готовые типа findAll и тд,должны называться именно так
@Service //тоже компонент
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Employee employee=null;
        Optional<Employee> optional=employeeRepository.findById(id);
        if(optional.isPresent()) {
            employee=optional.get();
        }
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAllByName(String name) {
        return employeeRepository.findAllByName(name);
    }
}
