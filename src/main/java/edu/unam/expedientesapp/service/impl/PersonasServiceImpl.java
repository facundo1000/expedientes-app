package edu.unam.expedientesapp.service.impl;

import edu.unam.expedientesapp.models.Persona;
import edu.unam.expedientesapp.repository.PersonaRepository;
import edu.unam.expedientesapp.service.ServiceCrud;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonasServiceImpl implements ServiceCrud<Persona> {

    private PersonaRepository repo;

    public PersonasServiceImpl(PersonaRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Persona> listar() {
        return repo.findAll();
    }

    @Override
    public Persona obtenerPorId(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public void crear(Persona persona) {
        repo.save(persona);
    }

    @Override
    public void actualizar(Long id, Persona persona) {

    }

    @Override
    public void eliminar(Long id) {

    }
}
