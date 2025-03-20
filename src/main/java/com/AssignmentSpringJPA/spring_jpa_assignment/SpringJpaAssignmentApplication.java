package com.AssignmentSpringJPA.spring_jpa_assignment;

import com.AssignmentSpringJPA.spring_jpa_assignment.Entity.Employee;
import com.AssignmentSpringJPA.spring_jpa_assignment.Service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaAssignmentApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringJpaAssignmentApplication.class, args);
//		Employee employee = new Employee(1, "Raj", 23, "Lucknow");
//		EmployeeService.saveEmployee(employee);
	}

}
