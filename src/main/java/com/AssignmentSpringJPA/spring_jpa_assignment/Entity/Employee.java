package com.AssignmentSpringJPA.spring_jpa_assignment.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//Q1: Create an Employee Entity which contains the following fields: Name, Id, Age, Location
@Entity
public class Employee {

    @Id
    Integer id;
    String name;
    Integer age;
    String location;

}
