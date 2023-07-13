package cl.awakelab.sprint6bootcamp.repository;

import cl.awakelab.sprint6bootcamp.entity.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrabajadorRepository extends JpaRepository<Trabajador, Integer> {
}
