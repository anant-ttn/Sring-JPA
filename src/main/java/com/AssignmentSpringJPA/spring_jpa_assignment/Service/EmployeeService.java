package com.AssignmentSpringJPA.spring_jpa_assignment.Service;

import com.AssignmentSpringJPA.spring_jpa_assignment.Entity.Employee;
import com.AssignmentSpringJPA.spring_jpa_assignment.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

//    Q3: Perform Create Operation on Entity using Spring Data JPA
    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
}
