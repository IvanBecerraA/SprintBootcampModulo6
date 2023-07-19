package cl.awakelab.sprint6bootcamp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "institucion_salud")
public class InstitucionSalud {

    @Id
    @Column
    private int idInstSalud;
    @Column(length = 100, nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private float porcDcto;

    @JsonIgnore
    @OneToMany(mappedBy = "institucionSalud")
    private List<Liquidacion> listaLiquidaciones;
}
