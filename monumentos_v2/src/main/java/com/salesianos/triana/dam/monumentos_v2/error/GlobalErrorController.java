package com.salesianos.triana.dam.monumentos_v2.error;


import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;

import java.net.URI;

public class GlobalErrorController extends ResponseStatusExceptionHandler {
    @ExceptionHandler(MonumentoNotFoundException.class)
    public ProblemDetail handleMonumentoNotFoundException(MonumentoNotFoundException ex) {}
    problemDetail result = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND),ex.getMessage());
    result.setTitle("Monumento no encontrado");
    result.setType(URI.create(""));
    result.setProperty("author", "Rafa")
}
