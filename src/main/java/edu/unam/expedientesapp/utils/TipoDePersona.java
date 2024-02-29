package edu.unam.expedientesapp.utils;

public enum TipoDePersona {
    INICIANTE("INICIANTE"),
    INVOLUCRADO("INVOLUCRADO"),
    MIEMBRO("MIEMBRO"),
    DIRECTOR("DIRECTOR"),
    NO_DOCENTE("NO_DOCENTE"),
    ESTUDIANTE("ESTUDIANTE");

    private final String nombre;

    TipoDePersona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
