package cl.awakelab.sprint6bootcamp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "institucion_prevision")
public class InstitucionPrevision {

    @Id
    @Column
    private int idInstPrevision;
    @Column(length = 50, nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private float porcDcto;

    @JsonIgnore
    @OneToMany(mappedBy = "institucionPrevision")
    private List<Trabajador> listaTrabajadores;

    @JsonIgnore
    @OneToMany(mappedBy = "institucionPrevision")
    private List<Liquidacion> listaLiquidaciones;
}
