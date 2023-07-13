package cl.awakelab.sprint6bootcamp.service;

import cl.awakelab.sprint6bootcamp.entity.InstitucionSalud;

import java.util.List;

public interface IInstitucionSaludService {

    InstitucionSalud create(InstitucionSalud institucionSalud);
    InstitucionSalud readById(int id);
    List<InstitucionSalud> readAll();
    InstitucionSalud update(InstitucionSalud institucionSalud);
    void delete(int id);

}
