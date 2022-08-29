package br.com.targetsolutions.challenge.service;

import br.com.targetsolutions.challenge.dto.EmployeeDTO;
import br.com.targetsolutions.challenge.exception.EmployeeNotFoundException;
import br.com.targetsolutions.challenge.model.Employee;
import br.com.targetsolutions.challenge.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DollarQuotationService dollarQuotationService;

    public Employee saveEmployee(EmployeeDTO employeeDTO) {

        return employeeRepository.save(Employee.fromDTO(employeeDTO));
    }

    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);

        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        employee.setAge(employeeDTO.getAge());
        employee.setRole(employeeDTO.getRole());
        employee.setEmail(employeeDTO.getEmail());

        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream()
                .map(this::calculateSalaryInBrlForEmployee)
                .collect(Collectors.toList());
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .map(this::calculateSalaryInBrlForEmployee)
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public void deleteEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
        employeeRepository.delete(employee);
    }

    public Employee calculateSalaryInBrlForEmployee(Employee employee) {
        BigDecimal dollarQuotation = dollarQuotationService.getDollarQuotationNow();

        BigDecimal brlSalary = employee.getSalary().multiply(dollarQuotation).setScale(2, RoundingMode.FLOOR);

        employee.setSalary(brlSalary);
        return employee;
    }
}
