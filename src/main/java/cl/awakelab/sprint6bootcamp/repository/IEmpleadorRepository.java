package cl.awakelab.sprint6bootcamp.repository;

import cl.awakelab.sprint6bootcamp.entity.Empleador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadorRepository extends JpaRepository<Empleador, Integer> {
}
