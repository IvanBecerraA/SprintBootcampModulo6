package cl.awakelab.sprint6bootcamp.service;

import cl.awakelab.sprint6bootcamp.entity.Trabajador;

import java.util.List;

public interface ITrabajadorService {

    Trabajador create(Trabajador trabajador);
    Trabajador readById(int id);
    List<Trabajador> readAll();
    Trabajador update(Trabajador trabajador);
    void delete(int id);

}
