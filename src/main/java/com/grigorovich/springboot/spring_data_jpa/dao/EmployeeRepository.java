package com.grigorovich.springboot.spring_data_jpa.dao;


import com.grigorovich.springboot.spring_data_jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> { //с каким классаом работает репозиторий, тип primary key
  //стандартные CRUD методы прописывать не надо
    public List<Employee> findAllByName(String name); //юлагодаря стандартизации метода метод реализовывать не надо, spring сам его реализует
}
