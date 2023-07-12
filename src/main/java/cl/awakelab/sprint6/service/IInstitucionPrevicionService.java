package cl.awakelab.sprint6.service;

import cl.awakelab.sprint6.entity.InstitucionPrevision;

import java.util.List;

public interface IInstitucionPrevicionService {

    InstitucionPrevision create(InstitucionPrevision institucionPrevision);
    InstitucionPrevision readById(int id);
    List<InstitucionPrevision> readAll();
    InstitucionPrevision update(InstitucionPrevision institucionPrevision);
    void delete(int id);

}
