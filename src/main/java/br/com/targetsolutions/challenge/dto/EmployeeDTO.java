package br.com.targetsolutions.challenge.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private String name;
    private BigDecimal salary;
    private int age;
    private String role;
    private String email;
}
