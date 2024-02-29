package edu.unam.expedientesapp.repository;

import edu.unam.expedientesapp.models.Reunion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReunionRepository extends JpaRepository<Reunion, Long> {
}
