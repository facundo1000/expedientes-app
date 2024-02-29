package edu.unam.expedientesapp.models;

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
@Getter
@Setter
@Table(name = "acciones_realizadas")
public class AccionesRealizadas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "accion_realizada")
    private String accionRealizada;

    @Column(name = "fecha_accion")
    private LocalDate fechaDeAccion;

    @ManyToMany(mappedBy = "acciones")
//    @JoinColumn(name = "expediente_id")
    private List<Expediente> expediente;

    private Boolean eliminado = Boolean.FALSE;

    @PrePersist
    public void prePersist() {
        this.eliminado = Boolean.FALSE;
    }

    @Serial
    private static final long serialVersionUID = 6934873892763176231L;
}
