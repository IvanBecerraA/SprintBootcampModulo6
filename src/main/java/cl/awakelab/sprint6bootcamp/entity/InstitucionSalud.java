package cl.awakelab.sprint6bootcamp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
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
