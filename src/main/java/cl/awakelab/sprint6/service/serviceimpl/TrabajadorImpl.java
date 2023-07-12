package cl.awakelab.sprint6.service.serviceimpl;

import cl.awakelab.sprint6.entity.Trabajador;
import cl.awakelab.sprint6.repository.ITrabajadorRepository;
import cl.awakelab.sprint6.service.ITrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("trabajadorImpl")
public class TrabajadorImpl implements ITrabajadorService {

    @Autowired
    ITrabajadorRepository trabajadorRepository;

    @Override
    public Trabajador create(Trabajador trabajador) {
        return trabajadorRepository.save(trabajador);
    }

    @Override
    public Trabajador readById(int id) {
        return trabajadorRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Trabajador no encontrado"));
    }

    @Override
    public List<Trabajador> readAll() {
        return trabajadorRepository.findAll();
    }

    @Override
    public Trabajador update(Trabajador trabajador) {
        return trabajadorRepository.save(trabajador);
    }

    @Override
    public void delete(int id) {
        trabajadorRepository.deleteById(id);
    }
}
