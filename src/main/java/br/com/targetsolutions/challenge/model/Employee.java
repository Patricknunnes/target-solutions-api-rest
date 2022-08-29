package br.com.targetsolutions.challenge.model;

import br.com.targetsolutions.challenge.dto.EmployeeDTO;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal salary;
    private int age;
    private String role;
    private String email;

    public static Employee fromDTO(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        employee.setAge(employeeDTO.getAge());
        employee.setRole(employeeDTO.getRole());
        employee.setEmail(employeeDTO.getEmail());

        return employee;
    }
}
