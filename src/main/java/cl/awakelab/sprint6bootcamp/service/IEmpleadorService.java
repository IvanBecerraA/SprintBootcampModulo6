package cl.awakelab.sprint6bootcamp.service;

import cl.awakelab.sprint6bootcamp.entity.Empleador;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface IEmpleadorService {

    Empleador create(Empleador empleador);
    Empleador readById(int id);
    List<Empleador> readAll();
    List<Empleador> readByUser(HttpSession session);
    Empleador update(Empleador empleador);
    void delete(int id);

}
