package edu.unam.expedientesapp.service;

import java.util.List;

public interface ServiceCrud <T>{
    List<T> listar();

    T obtenerPorId(Long id);

    void crear(T t);

    void actualizar(Long id, T t);

    void eliminar(Long id);
}
