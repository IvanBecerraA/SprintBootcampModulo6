package cl.awakelab.sprint6bootcamp.service;

import cl.awakelab.sprint6bootcamp.entity.Empleador;
import cl.awakelab.sprint6bootcamp.entity.Trabajador;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface ITrabajadorService {

    Trabajador create(Trabajador trabajador);
    Trabajador create(Trabajador trabajador, Empleador empleador);
    Trabajador create(Trabajador trabajador, List<Integer> empleadores);
    Trabajador readById(int id);
    List<Trabajador> readAll();
    List<Trabajador> readByUser(HttpSession session);
    List<Trabajador> readByEmployer(Empleador empleador);
    Trabajador update(Trabajador trabajador);
    Trabajador update(Trabajador trabajador, List<Integer> empleadores);
    void delete(int id);

}
