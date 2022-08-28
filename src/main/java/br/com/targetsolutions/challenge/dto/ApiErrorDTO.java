package br.com.targetsolutions.challenge.dto;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorDTO {

    private String message;
    private Instant timestamp;

}
