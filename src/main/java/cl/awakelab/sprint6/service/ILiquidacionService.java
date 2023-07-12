package cl.awakelab.sprint6.service;

import cl.awakelab.sprint6.entity.Liquidacion;

import java.util.List;

public interface ILiquidacionService {

    Liquidacion create(Liquidacion liquidacion);
    Liquidacion readById(int id);
    List<Liquidacion> readAll();
    Liquidacion update(Liquidacion liquidacion);
    void delete(int id);

}
