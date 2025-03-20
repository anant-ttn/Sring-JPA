package com.AssignmentSpringJPA.spring_jpa_assignment.Controllers;

import com.AssignmentSpringJPA.spring_jpa_assignment.Entity.Employee;
import com.AssignmentSpringJPA.spring_jpa_assignment.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;


    @GetMapping("/")
    public String health(){
        return "Working fine";
    }

//    Q6: Perform Read Operation on Entity using Spring Data JPA

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> allEmployees = employeeService.getEmployees();
        return new ResponseEntity<>(allEmployees, HttpStatus.OK);
    }

//    Q7: getting count fo all employees
    @GetMapping("/employees/totalcount")
    public ResponseEntity<Integer> getCountEmployees(){
        List<Employee> allEmployees = employeeService.getEmployees();
        return new ResponseEntity<>(allEmployees.size(), HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee (@RequestBody Employee employee){
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }


    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        try {
            Employee updatedEmployee = employeeService.updateEmployee(id, employee);
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
        } catch (RuntimeException e) {
            System.out.println("This works");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Q5: Perform Delete Operation on Entity using Spring Data JPA
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Integer id){
        try{
            Employee employeeDeletesd = employeeService.deleteEmployee(id);
            return new ResponseEntity<>(employeeDeletesd, HttpStatus.OK);
        } catch (RuntimeException e) {
//            System.out.println("This works");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//Q8: Implement Pagination and Sorting on the bases of Employee Age
    @GetMapping("employees/paginated")
    public ResponseEntity<Page<Employee>> getEmployeesWithPaginationAndSorting(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "asc") String sortDirection) {

        Page<Employee> employees = employeeService.getEmployeesWithPaginationAndSorting(page, size, sortDirection);
        return ResponseEntity.ok(employees);
    }

//    Q9: Create and use finder to find Employee by Name
    @GetMapping("employees/{name}")
    public ResponseEntity<Employee> getEmployeeWuithName(@PathVariable String name){
        Employee employeeWithName = employeeService.getEmployeeByName(name);
        System.out.println("tjhis cior");
        return new ResponseEntity<>(employeeWithName, HttpStatus.OK);
    }

//    q10: Create and use finder to find Employees starting with A character
    @GetMapping("/starting-with/{cha}")
    public ResponseEntity<List<Employee>> getEmployeesStartingWithA(@PathVariable String cha) {
        List<Employee> employees = employeeService.getEmployeesStartingWith(cha);
        return ResponseEntity.ok(employees);
    }
}
