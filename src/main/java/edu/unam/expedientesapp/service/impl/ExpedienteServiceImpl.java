package edu.unam.expedientesapp.service.impl;

import edu.unam.expedientesapp.exception.NotFoundException;
import edu.unam.expedientesapp.models.Expediente;
import edu.unam.expedientesapp.repository.ExpedienteRepository;
import edu.unam.expedientesapp.service.ServiceCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static edu.unam.expedientesapp.utils.ErrorType.EXPEDIENTE_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ExpedienteServiceImpl implements ServiceCrud<Expediente> {

    private final ExpedienteRepository repo;

    @Override
    public List<Expediente> listar() {
        return repo.findAll();
    }

    @Override
    public Expediente obtenerPorId(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public void crear(Expediente expediente) {
        repo.save(expediente);
    }

    @Override
    public Expediente actualizar(Long id, Expediente expediente) {

        if (id > 0) {
            Optional<Expediente> update = repo.findById(id);

            if (update.isPresent()) {
                update.get().setAcciones(expediente.getAcciones());
                update.get().setIniciante(expediente.getIniciante());
                update.get().setMinuta(expediente.getMinuta());
                update.get().setEstadoDelExpediente(expediente.getEstadoDelExpediente());
                update.get().setIngresoFacultad(expediente.getIngresoFacultad());
                update.get().setInvolucrados(expediente.getInvolucrados());
                update.get().setReuniones(expediente.getReuniones());
                update.get().setTextNota(expediente.getTextNota());
                update.get().setEliminado(expediente.getEliminado());
                return repo.save(update.get());
            }
        }

        throw new NotFoundException(EXPEDIENTE_NOT_FOUND, "Expediente N°: " + id + " no puede ser actualizado");
    }

    @Override
    public void eliminar(Long id) {
        Optional<Expediente> update = repo.findById(id);
        update.ifPresent(expediente -> expediente.setEliminado(true));
        repo.save(update.get());
    }
}
