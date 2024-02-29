package edu.unam.expedientesapp.repository;

import edu.unam.expedientesapp.models.Expediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpedienteRepository extends JpaRepository<Expediente, Long> {
}
