package edu.unam.expedientesapp.models;

import java.io.Serializable;
import java.util.Set;
// ESTA CLASE NO ME QUEDA CLARA

// @Entity
// @Table(name = "consejo_departamental")
public class ConsejoDepartamental  implements Serializable {
    private Long id;

    //  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //  @JoinTable(
    //      name = "tbl_consejo_personas",
    //      joinColumns = @JoinColumn(name = "consejo_id"),
    //      inverseJoinColumns = @JoinColumn(name = "personas_id"),
    //      uniqueConstraints = @UniqueConstraint(columnNames = {"consejo_id", "personas_id"}))
    private Set<Persona> miembros;
}
