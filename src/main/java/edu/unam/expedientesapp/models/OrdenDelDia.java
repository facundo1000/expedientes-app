package edu.unam.expedientesapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "minutas")
public class OrdenDelDia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String minuta;

    @ManyToOne private Expediente expediente;
    @OneToOne private Reunion reunion;

    @Serial
    private static final long serialVersionUID = 1151961427292635251L;
}
