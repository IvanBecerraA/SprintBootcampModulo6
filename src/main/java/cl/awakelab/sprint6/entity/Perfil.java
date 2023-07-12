package cl.awakelab.sprint6.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
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
