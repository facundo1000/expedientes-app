package edu.unam.expedientesapp.repository;

import edu.unam.expedientesapp.models.AccionesRealizadas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccionesRepository extends JpaRepository<AccionesRealizadas, Long> {
}
