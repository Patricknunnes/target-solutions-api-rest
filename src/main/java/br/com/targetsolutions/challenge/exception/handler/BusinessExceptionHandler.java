package br.com.targetsolutions.challenge.exception.handler;

import br.com.targetsolutions.challenge.dto.ApiErrorDTO;
import br.com.targetsolutions.challenge.exception.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class BusinessExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
        ApiErrorDTO apiErrorDTO = ApiErrorDTO.builder().message("No employee found with given Id").timestamp(Instant.now()).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiErrorDTO);
    }

}
