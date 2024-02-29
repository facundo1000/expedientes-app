package edu.unam.expedientesapp.service.impl;

import edu.unam.expedientesapp.models.Persona;
import edu.unam.expedientesapp.repository.PersonaRepository;
import edu.unam.expedientesapp.service.ServiceCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonasServiceImpl implements ServiceCrud<Persona> {

    private final PersonaRepository repo;

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
    public Persona actualizar(Long id, Persona persona) {
        Optional<Persona> update = repo.findById(id);

        if(update.isPresent()){
            update.get().setNombre(persona.getNombre());
            update.get().setApellido(persona.getApellido());
            update.get().setTipoDoc(persona.getTipoDoc());
            update.get().setDni(persona.getDni());
            update.get().setTelefono(persona.getTelefono());
            update.get().setEmail(persona.getEmail());
            update.get().setAsistencia(persona.getAsistencia());
            update.get().setBday(persona.getBday());
            update.get().setEliminado(persona.getEliminado());
            update.get().setTipoDePersona(persona.getTipoDePersona());
        }
       return repo.save(update.get());
    }

    @Override
    public void eliminar(Long id) {
        Optional<Persona> update = repo.findById(id);
        update.ifPresent(persona -> persona.setEliminado(true));
        repo.save(update.get());
    }
}
