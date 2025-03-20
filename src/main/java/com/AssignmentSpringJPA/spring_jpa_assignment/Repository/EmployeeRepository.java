package com.AssignmentSpringJPA.spring_jpa_assignment.Repository;

import com.AssignmentSpringJPA.spring_jpa_assignment.Entity.Employee;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//Q2: Set up EmployeeRepository with Spring Data JPA

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
