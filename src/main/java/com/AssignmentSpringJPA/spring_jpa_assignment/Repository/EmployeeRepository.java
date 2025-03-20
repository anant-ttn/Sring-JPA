package com.AssignmentSpringJPA.spring_jpa_assignment.Repository;

import com.AssignmentSpringJPA.spring_jpa_assignment.Entity.Employee;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

//Q2: Set up EmployeeRepository with Spring Data JPA

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    Page<Employee> findAll(Pageable pageable);
    Optional<Employee> findByName(String name);
    //    Q10: Create and use finder to find Employees starting with A character
    List<Employee> findByNameStartingWith(String prefix);
}
