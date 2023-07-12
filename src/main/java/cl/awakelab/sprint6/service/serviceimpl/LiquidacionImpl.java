package cl.awakelab.sprint6.service.serviceimpl;

import cl.awakelab.sprint6.entity.Liquidacion;
import cl.awakelab.sprint6.repository.ILiquidacionRepository;
import cl.awakelab.sprint6.service.ILiquidacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("liquidacionImpl")
public class LiquidacionImpl implements ILiquidacionService {

    @Autowired
    ILiquidacionRepository liquidacionRepository;

    @Override
    public Liquidacion create(Liquidacion liquidacion) {
        return liquidacionRepository.save(liquidacion);
    }

    @Override
    public Liquidacion readById(int id) {
        return liquidacionRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Liquidación no encontrada"));
    }

    @Override
    public List<Liquidacion> readAll() {
        return liquidacionRepository.findAll();
    }

    @Override
    public Liquidacion update(Liquidacion liquidacion) {
        return liquidacionRepository.save(liquidacion);
    }

    @Override
    public void delete(int id) {
        liquidacionRepository.deleteById(id);
    }
}
