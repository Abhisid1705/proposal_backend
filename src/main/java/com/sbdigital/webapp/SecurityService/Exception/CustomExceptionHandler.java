package com.sbdigital.webapp.SecurityService.Exception;

import com.sbdigital.webapp.SecurityService.Domain.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import javax.persistence.EntityNotFoundException;
import javax.security.auth.login.CredentialException;

@RestController
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ExceptionResponse> handleInvalidCredentials(BadCredentialsException e){
        ExceptionResponse exceptionResponse = new ExceptionResponse (HttpStatus.UNAUTHORIZED , e.getLocalizedMessage());
        return  new ResponseEntity<ExceptionResponse>(exceptionResponse , exceptionResponse.getStatus());
    }


}
