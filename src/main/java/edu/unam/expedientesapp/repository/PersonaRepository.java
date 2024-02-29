package edu.unam.expedientesapp.repository;

import edu.unam.expedientesapp.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
