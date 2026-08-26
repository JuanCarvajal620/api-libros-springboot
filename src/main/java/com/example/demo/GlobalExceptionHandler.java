package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LibroNoEncontradoException.class)
    public ResponseEntity<ErrorDTO> manejarLibroNoEncontrado(LibroNoEncontradoException ex) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorDTO(ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> manejarErrorValidacion(MethodArgumentNotValidException ex) {
        String mensaje;

        if (ex.getBindingResult().getFieldError() != null) {
            mensaje = ex.getBindingResult()
                    .getFieldError()
                    .getDefaultMessage();

        } else {
            mensaje = "Error de validación";
               }

        return ResponseEntity
                .badRequest()
                .body(new ErrorDTO(mensaje));
    }

}