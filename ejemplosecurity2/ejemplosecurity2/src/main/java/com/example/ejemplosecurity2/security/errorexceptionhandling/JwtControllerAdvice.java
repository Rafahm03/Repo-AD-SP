package com.example.ejemplosecurity2.security.errorexceptionhandling;

import com.example.ejemplosecurity2.security.jwt.access.JwtException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class JwtControllerAdvice  extends ResponseEntityExceptionHandler {


    public ProblemDetail handAuthenticationException(AuthenticationException ex, HttpServletRequest request){

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.UNAUTHORIZED, ex.getMessage());

        //Añadir un header WWW-authentication


        return problemDetail;


    }

    @ExceptionHandler(JwtException){
        
    }


}
