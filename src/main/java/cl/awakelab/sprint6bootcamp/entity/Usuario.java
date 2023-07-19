package cl.awakelab.sprint6bootcamp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    @Column(unique = true, nullable = false)
    private int run;
    @Column(length = 200, nullable = false)
    private String clave;
    @Column(length = 100, nullable = false)
    private String nombre;
    @Column(name = "apellido_1", length = 100, nullable = false)
    private String apellido1;
    @Column(name = "apellido_2", length = 100)
    private String apellido2;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_perfil", nullable = false)
    private Perfil perfil;

    @Column(length = 100, nullable = false)
    private String email;
    @Column(nullable = false)
    private LocalDateTime fechaCreacion;
    @Column
    private long telefono;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Empleador> listaEmpleadores;

}
