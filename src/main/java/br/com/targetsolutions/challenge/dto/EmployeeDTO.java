package br.com.targetsolutions.challenge.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Salary is mandatory")
    private BigDecimal salary;

    @NotNull(message = "Age is mandatory")
    @Min(value = 16, message = "age must be over 16")
    private int age;

    @NotBlank(message = "Role is mandatory")
    private String role;

    @NotBlank(message = "Email is mandatory")
    private String email;
}
