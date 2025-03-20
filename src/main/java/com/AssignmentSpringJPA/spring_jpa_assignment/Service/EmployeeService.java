package com.AssignmentSpringJPA.spring_jpa_assignment.Service;

import com.AssignmentSpringJPA.spring_jpa_assignment.Entity.Employee;
import com.AssignmentSpringJPA.spring_jpa_assignment.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    //    Q3: Perform Create Operation on Entity using Spring Data JPA
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    //    Q4: Perform Update Operation on Entity using Spring Data JPA'
    //Added h2 db for this
    public Employee updateEmployee(Integer id, Employee updatedEmployee) {
        Optional<Employee> existingEmployeeOpt = employeeRepository.findById(id);

        if (existingEmployeeOpt.isPresent()) {
            Employee existingEmployee = existingEmployeeOpt.get();
            existingEmployee.setName(updatedEmployee.getName());
            existingEmployee.setAge(updatedEmployee.getAge());
            existingEmployee.setLocation(updatedEmployee.getLocation());

            return employeeRepository.save(existingEmployee);
        } else {
            throw new RuntimeException("Employee with ID " + id + " not found.");
        }
    }
}
