package br.com.targetsolutions.challenge.controller.form;

import br.com.targetsolutions.challenge.model.Employee;
import br.com.targetsolutions.challenge.repository.EmployeeRepository;

public class EmployeeForm {

    private String name;

    private double salary;

    private int age;

    private String role;

    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee conversor() {
        return new Employee(name, salary, age, role, email);
    }

    public Employee update(Long id, EmployeeRepository employeeRepository) {
        Employee employee = employeeRepository.getReferenceById(id);
        employee.setName(this.name);
        employee.setSalary(this.salary);
        employee.setAge(this.age);
        employee.setRole(this.role);
        employee.setEmail(this.email);
        return employee;
    }
}
