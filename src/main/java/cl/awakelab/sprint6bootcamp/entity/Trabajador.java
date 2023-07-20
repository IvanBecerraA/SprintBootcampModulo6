package cl.awakelab.sprint6bootcamp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "trabajador")
public class Trabajador {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTrabajador;
    @Column(unique = true, nullable = false)
    private int run;
    @Column(length = 100, nullable = false)
    private String nombre;
    @Column(name = "apellido_1", length = 100, nullable = false)
    private String apellido1;
    @Column(name = "apellido_2", length = 100)
    private String apellido2;
    @Column(length = 100)
    private String email;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_inst_prevision", nullable = false)
    private InstitucionPrevision institucionPrevision;
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_inst_salud", nullable = false)
    private InstitucionSalud institucionSalud;

    @Column
    private long telefono;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "empl_trab",
            joinColumns = @JoinColumn(name = "id_Trabajador", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_empleador", nullable = false))
    private List<Empleador> listaEmpleadores;

    @JsonIgnore
    @OneToMany(mappedBy = "trabajador")
    private List<Liquidacion> listaLiquidaciones;

}
