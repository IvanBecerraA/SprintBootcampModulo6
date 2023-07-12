package cl.awakelab.sprint6.service;

import cl.awakelab.sprint6.entity.Trabajador;

import java.util.List;

public interface ITrabajadorService {

    Trabajador create(Trabajador trabajador);
    Trabajador readById(int id);
    List<Trabajador> readAll();
    Trabajador update(Trabajador trabajador);
    void delete(int id);

}
