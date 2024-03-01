package edu.unam.expedientesapp.service.impl;

import edu.unam.expedientesapp.exception.NotFoundException;
import edu.unam.expedientesapp.models.AccionesRealizadas;
import edu.unam.expedientesapp.repository.AccionesRepository;
import edu.unam.expedientesapp.service.ServiceCrud;
import edu.unam.expedientesapp.utils.ErrorType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static edu.unam.expedientesapp.utils.ErrorType.ACCION_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class AccionesServiceImpl implements ServiceCrud<AccionesRealizadas> {

    private final AccionesRepository repo;

    @Override
    public List<AccionesRealizadas> listar() {
        return repo.findAll();
    }

    @Override
    public AccionesRealizadas obtenerPorId(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public void crear(AccionesRealizadas accionesRealizadas) {
        repo.save(accionesRealizadas);
    }

    @Override
    public AccionesRealizadas actualizar(Long id, AccionesRealizadas accionesRealizadas) {

        if(id > 0){
            Optional<AccionesRealizadas> update = repo.findById(id);
            if (update.isPresent()) {
                update.get().setAccionRealizada(accionesRealizadas.getAccionRealizada());
                update.get().setFechaDeAccion(accionesRealizadas.getFechaDeAccion());
                update.get().setExpediente(accionesRealizadas.getExpediente());
                update.get().setEliminado(accionesRealizadas.getEliminado());
                return repo.save(update.get());
            }
        }
        throw new NotFoundException(ACCION_NOT_FOUND,"Accion N°: " + id + " no pudo ser actualizada");
    }

    @Override
    public void eliminar(Long id) {
        Optional<AccionesRealizadas> update = repo.findById(id);
        update.ifPresent(accionesRealizadas -> accionesRealizadas.setEliminado(true));
        repo.save(update.get());
    }
}
