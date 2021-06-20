package com.sbdigital.webapp.SecurityService.Domain;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ExceptionResponse {

    private HttpStatus status;
    private String message;

}
