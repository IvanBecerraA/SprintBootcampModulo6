package cl.awakelab.sprint6bootcamp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "empleador")
public class Empleador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpleador;
    @Column(unique = true, nullable = false)
    private int run;
    @Column(length = 100, nullable = false)
    private String nombre;
    @Column(name = "apellido_1", length = 100, nullable = false)
    private String apellido1;
    @Column(name = "apellido_2", length = 100)
    private String apellido2;
    @Column(length = 100)
    private String direccion;
    @Column(length = 100)
    private String email;
    @Column
    private long telefono;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @JsonIgnore
    @ManyToMany(mappedBy = "listaEmpleadores")
    private List<Trabajador> listaTrabajadores;

}
