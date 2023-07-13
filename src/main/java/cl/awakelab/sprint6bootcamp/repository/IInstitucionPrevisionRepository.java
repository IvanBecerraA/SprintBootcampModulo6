package cl.awakelab.sprint6bootcamp.repository;

import cl.awakelab.sprint6bootcamp.entity.InstitucionPrevision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInstitucionPrevisionRepository extends JpaRepository<InstitucionPrevision, Integer> {
}
