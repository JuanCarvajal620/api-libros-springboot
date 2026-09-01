package com.example.demo;

public class LibroDuplicadoException
        extends RuntimeException {

    public LibroDuplicadoException(
            String mensaje
    ) {
        super(mensaje);
    }
}
