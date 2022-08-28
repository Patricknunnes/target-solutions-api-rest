package br.com.targetsolutions.challenge.service;

import br.com.targetsolutions.challenge.dto.EmployeeDTO;
import br.com.targetsolutions.challenge.model.Employee;
import br.com.targetsolutions.challenge.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void canSaveANewEmployee() {
        EmployeeDTO employeeDTO = EmployeeDTO.builder()
                .name("Patrick")
                .age(20)
                .email("patrick@mail.com")
                .salary(new BigDecimal("3200.0"))
                .role("MANAGER")
                .build();

        Employee employeeToBeSaved = new Employee();
        employeeToBeSaved.setName("Patrick");
        employeeToBeSaved.setAge(20);
        employeeToBeSaved.setEmail("patrick@mail.com");
        employeeToBeSaved.setRole("MANAGER");
        employeeToBeSaved.setSalary(new BigDecimal("3200.0"));

        given(employeeRepository.save(employeeToBeSaved)).willReturn(employeeToBeSaved);

        Employee savedEmployee = employeeService.saveEmployee(employeeDTO);

        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.getName()).isEqualTo("Patrick");
    }


}