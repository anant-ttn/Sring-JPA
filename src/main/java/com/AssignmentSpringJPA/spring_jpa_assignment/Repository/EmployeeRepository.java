package com.AssignmentSpringJPA.spring_jpa_assignment.Repository;

import com.AssignmentSpringJPA.spring_jpa_assignment.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//Q2: Set up EmployeeRepository with Spring Data JPA

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
