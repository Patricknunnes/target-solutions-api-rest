package br.com.targetsolutions.challenge.controller;

import br.com.targetsolutions.challenge.controller.form.EmployeeForm;
import br.com.targetsolutions.challenge.model.Employee;
import br.com.targetsolutions.challenge.repository.EmployeeRepository;
import br.com.targetsolutions.challenge.service.DollarPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DollarPriceService dollarPriceService;

    @GetMapping("/list")
    public List<Employee> getEmployee(@RequestParam(required = false) String name){
        if (name == null) {
            List<Employee> employees = employeeRepository.findAll();
            employees.forEach(employee -> {
                double newSalary = dollarPriceService.convertCurrency(employee.getSalary());
                employee.setSalary(newSalary);
            });
            return employees;
        } else {
            List<Employee> employees = employeeRepository.findByName(name);
            employees.forEach(employee -> {
                double newSalary = dollarPriceService.convertCurrency(employee.getSalary());
                employee.setSalary(newSalary);
            });
            return employees;
        }
    }

    @PostMapping("/register")
    @Transactional
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeForm form){
        Employee employee = form.conversor();
        return ResponseEntity.ok().body(employeeRepository.save(employee));
    }

    @PutMapping("/update/{id}")
    @Transactional
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody EmployeeForm employeeForm) {
        Employee employee = employeeForm.update(id, employeeRepository);
        return ResponseEntity.ok(employeeRepository.save(employee));
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id){
        if (employeeRepository.findById(id).isPresent()){
            employeeRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
