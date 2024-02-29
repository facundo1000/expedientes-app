package edu.unam.expedientesapp.models;

import edu.unam.expedientesapp.utils.Estado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "expedientes")
public class Expediente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "texto_nota")
    private String textNota;

    @Column(name = "fecha_ingreso_facultad")
    private LocalDate ingresoFacultad;

    @OneToOne
    private Persona iniciante;

    @Column(name = "estado_expediente")
    @Enumerated(EnumType.STRING)
    private Estado estadoDelExpediente;

    private Boolean eliminado = Boolean.FALSE;

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY)
    @JoinTable(
            name = "tbl_expedientes_involucrados",
            joinColumns = @JoinColumn(name = "expediente_id"),
            inverseJoinColumns = @JoinColumn(name = "personas_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"expediente_id", "personas_id"}))
    private List<Persona> involucrados;

    @ManyToMany(
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    @JoinTable(
            name = "tbl_expedientes_accciones",
            joinColumns = @JoinColumn(name = "expediente_id"),
            inverseJoinColumns = @JoinColumn(name = "acciones_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"expediente_id", "acciones_id"}))
    private List<AccionesRealizadas> acciones;

    @ManyToMany(
            mappedBy = "expedientesAbiertos",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Reunion> reuniones;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "tbl_expedientes_minutas",
            joinColumns = @JoinColumn(name = "expediente_id"),
            inverseJoinColumns = @JoinColumn(name = "minuta_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"expediente_id", "minuta_id"}))
    private List<OrdenDelDia> minuta;

    @Serial
    private static final long serialVersionUID = 5431415207794021675L;
}
