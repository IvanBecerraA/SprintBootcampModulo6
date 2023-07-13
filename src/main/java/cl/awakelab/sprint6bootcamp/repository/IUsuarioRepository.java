package cl.awakelab.sprint6bootcamp.repository;

import cl.awakelab.sprint6bootcamp.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
}
