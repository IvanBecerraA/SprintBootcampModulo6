package cl.awakelab.sprint6bootcamp.service;

import cl.awakelab.sprint6bootcamp.entity.Empleador;
import cl.awakelab.sprint6bootcamp.entity.Usuario;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface IEmpleadorService {

    Empleador create(Empleador empleador);
    Empleador readById(int id);
    List<Empleador> readAll();
    List<Empleador> readByUser(Usuario usuario);
    Empleador update(Empleador empleador);
    void delete(int id);

}
