package cl.awakelab.sprint6.service;

import cl.awakelab.sprint6.entity.Empleador;

import java.util.List;

public interface IEmpleadorService {

    Empleador create(Empleador empleador);
    Empleador readById(int id);
    List<Empleador> readAll();
    Empleador update(Empleador empleador);
    void delete(int id);

}
