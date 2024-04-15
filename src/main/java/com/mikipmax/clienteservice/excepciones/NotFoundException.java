package com.mikipmax.clienteservice.excepciones;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String entidadNoEncontrada) {
        super(entidadNoEncontrada);
    }
}
