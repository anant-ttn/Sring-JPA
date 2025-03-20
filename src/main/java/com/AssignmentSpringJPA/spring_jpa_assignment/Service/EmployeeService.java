package com.AssignmentSpringJPA.spring_jpa_assignment.Service;

import com.AssignmentSpringJPA.spring_jpa_assignment.Entity.Employee;
import com.AssignmentSpringJPA.spring_jpa_assignment.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import java.util.List;
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

    //Q5: Perform Delete Operation on Entity using Spring Data JPA
    public Employee deleteEmployee(Integer id){
        Optional<Employee> existingEmployeetoDeleteOpt = employeeRepository.findById(id);
        if(existingEmployeetoDeleteOpt.isPresent()){
            Employee employeeToDelete = existingEmployeetoDeleteOpt.get();
            employeeRepository.delete(employeeToDelete);
            return employeeToDelete;
        } else {
            throw new RuntimeException("Employee with ID " + id + " not found.");
        }

    }
//    Q6: Perform Read Operation on Entity using Spring Data JPA
    public List<Employee> getEmployees(){
        List<Employee> allEmployee = (List<Employee>) employeeRepository.findAll();
        return allEmployee;
    }
// Q8: Implement Pagination and Sorting on the bases of Employee Age
    public Page<Employee> getEmployeesWithPaginationAndSorting(int page, int size, String sortDirection) {
        Sort sort = Sort.by("age"); // Sorting by age
        sort = sortDirection.equalsIgnoreCase("desc") ? sort.descending() : sort.ascending();

        Pageable pageable = PageRequest.of(page, size, sort);
        return employeeRepository.findAll(pageable);
    }


}
