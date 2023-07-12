package cl.awakelab.sprint6.service;

import cl.awakelab.sprint6.entity.Usuario;

import java.util.List;

public interface IUsuarioService {

    Usuario create(Usuario usuario);
    Usuario readById(int id);
    List<Usuario> readAll();
    Usuario update(Usuario usuario);
    void delete(int id);

}
