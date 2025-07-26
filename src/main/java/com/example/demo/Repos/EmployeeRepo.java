package com.example.demo.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
