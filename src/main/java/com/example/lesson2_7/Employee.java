package com.example.lesson2_7;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private Integer passport;

    public Employee (String firstName, String lastName, Integer passport){
        this.firstName = firstName;
        this.lastName = lastName;
        this.passport = passport;
    }

    public String getFirstName (){
        return this.firstName;
    }
    public String getLastName (){
        return this.lastName;
    }
    public Integer getPassport() {
        return this.passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName)
                && Objects.equals(passport, employee.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, passport);
    }

    public String toString(){
        return "сотрудник: " + firstName + " " + lastName + " " + passport;
    }

}
