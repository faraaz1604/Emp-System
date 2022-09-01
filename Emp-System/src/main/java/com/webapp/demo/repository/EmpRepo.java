package com.webapp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapp.demo.entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer>{

}
