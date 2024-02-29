package edu.unam.expedientesapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "reuniones")
public class Reunion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String ciudad;

    @Column(name = "fecha_reunion")
    private LocalDateTime fechaReunion;

    @Column(name = "temas_tratados", length = 50)
    private String temasTratados;

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY)
    @JoinTable(
            name = "tbl_reunion_expedientes",
            joinColumns = @JoinColumn(name = "reunion_id"),
            inverseJoinColumns = @JoinColumn(name = "expediente_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"reunion_id", "expediente_id"}))
    private List<Expediente> expedientesAbiertos;

    @ManyToMany(
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    @JoinTable(
            name = "tbl_reunion_personas",
            joinColumns = @JoinColumn(name = "reunion_id"),
            inverseJoinColumns = @JoinColumn(name = "persona_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"reunion_id", "persona_id"}))
    private Set<Persona> miembros;

    @OneToOne(mappedBy = "reunion")
    private OrdenDelDia minuta;

    @Serial
    private static final long serialVersionUID = 7119641279628433714L;
}
