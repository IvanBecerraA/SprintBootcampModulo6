package cl.awakelab.sprint6.service;

import cl.awakelab.sprint6.entity.Perfil;

import java.util.List;

public interface IPerfilService {

    Perfil create(Perfil perfil);
    Perfil readById(int id);
    List<Perfil> readAll();
    Perfil update(Perfil perfil);
    void delete(int id);


}
