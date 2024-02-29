package edu.unam.expedientesapp.models;

import edu.unam.expedientesapp.utils.TipoDeDocumento;
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
@Table(name = "personas")
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String nombre;

    @Column(length = 20)
    private String apellido;

    @Column(length = 20)
    private String dni;

    @Column(length = 30, unique = true)
    private String telefono;

    @Column(length = 50, unique = true)
    private String email;

    @Column(name = "tipo_persona")
    @ElementCollection
    private List<String> tipoDePersona;

    @Column(name = "tipo_doc")
    @Enumerated(EnumType.STRING)
    private TipoDeDocumento tipoDoc;

    @Column(name = "fecha_nac")
    private LocalDate bday;

    private Boolean asistencia;

    private Boolean eliminado;


    @PrePersist
    public void setAsistenciaFalse() {
        asistencia = Boolean.FALSE;
        this.eliminado = Boolean.FALSE;
    }

    @Serial
    private static final long serialVersionUID = -2797355784527702277L;
}
