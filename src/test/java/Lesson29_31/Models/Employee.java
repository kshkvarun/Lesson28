package Lesson29_31.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Employee {

    @JsonProperty("id")
    Integer id;
    @JsonProperty("employee_nam")
    String employee_name;
    @JsonProperty("employee_salary")
    Integer employee_salary;
    @JsonProperty("employee_age")
    Integer employee_age;
    @JsonProperty("profile_image")
    String profile_image;

    public Employee(String employee_Name, Integer employeeSalary, Integer employeeAge, String profileImage) {
        this.employee_name = employee_Name;
        this.employee_salary = employeeSalary;
        this.employee_age = employeeAge;
        this.profile_image = profileImage;
    }

    public Employee() {
    }

    public Employee(Object o) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employee_name, employee.employee_name) &&
                Objects.equals(employee_salary, employee.employee_salary) &&
                Objects.equals(employee_age, employee.employee_age) &&
                Objects.equals(profile_image, employee.profile_image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee_name, employee_salary, employee_age, profile_image);
    }
}
