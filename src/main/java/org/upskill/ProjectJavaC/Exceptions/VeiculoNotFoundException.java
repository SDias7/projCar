package org.upskill.ProjectJavaC.Exceptions;

public class VeiculoNotFoundException extends RuntimeException {
    public VeiculoNotFoundException(String message) {
        super(message);
    }
}