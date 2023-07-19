package cl.awakelab.sprint6bootcamp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "perfil")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPerfil;
    @Column(length = 50, nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private Boolean estado;

    @JsonIgnore
    @OneToMany(mappedBy = "perfil")
    private List<Usuario> listaUsuarios;
}
