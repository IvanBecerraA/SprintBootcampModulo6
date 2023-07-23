package cl.awakelab.sprint6bootcamp.service;

import cl.awakelab.sprint6bootcamp.entity.Liquidacion;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface ILiquidacionService {

    Liquidacion create(Liquidacion liquidacion);
    Liquidacion readById(int id);
    List<Liquidacion> readAll();
    List<Liquidacion> readByUser(HttpSession session);
    Liquidacion update(Liquidacion liquidacion);
    void delete(int id);

}
