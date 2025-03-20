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

    //    improvement in Q1: adding the setter and getters and also constructors
    public Employee(Integer id, String name, Integer age, String location) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }



}
