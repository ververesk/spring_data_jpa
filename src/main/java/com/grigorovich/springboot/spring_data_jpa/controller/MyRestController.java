package com.grigorovich.springboot.spring_data_jpa.controller;

import com.grigorovich.springboot.spring_data_jpa.entity.Employee;
import com.grigorovich.springboot.spring_data_jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{id}") //получаем работника по id
    public Employee getEmployee(@PathVariable int id) { //@PathVariable используется для получения значения переменной из адреса запроса
        Employee employee = employeeService.getEmployee(id);
        return employee;
    }
    @PostMapping("/employees") //для добавдения нового работника используется метод пост, потому что в теле будет передаваться инф о новом работнике
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }
    @PutMapping("/employees") //для изменения нового работника используется метод put, потому что в теле будет передаваться инф о новом работнике
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }
    @DeleteMapping ("/employees/{id}") //@DeleteMapping связывает http запрос, использующий http метод delete c методом контроллера
    public String deleteEmployee(@PathVariable int id) {
        Employee employee=employeeService.getEmployee(id);
        employeeService.deleteEmployee(id);
        return "Employee with id="+id+" was deleted";
    }

    @GetMapping("/employees/name/{name}")
    public List<Employee> showAllEmployeesByNAme(@PathVariable String name) {
        List<Employee> allEmployees = employeeService.findAllByName(name);
        return allEmployees;
    }



}
