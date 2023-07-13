package cl.awakelab.sprint6bootcamp.service.serviceimpl;

import cl.awakelab.sprint6bootcamp.entity.Empleador;
import cl.awakelab.sprint6bootcamp.repository.IEmpleadorRepository;
import cl.awakelab.sprint6bootcamp.service.IEmpleadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("empleadorImpl")
public class EmpleadorImpl implements IEmpleadorService {

    @Autowired
    IEmpleadorRepository empleadorRepository;


    @Override
    public Empleador create(Empleador empleador) {
        return empleadorRepository.save(empleador);
    }

    @Override
    public Empleador readById(int id) {
        return empleadorRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Empleador no encontrado"));
    }

    @Override
    public List<Empleador> readAll() {
        return empleadorRepository.findAll();
    }

    @Override
    public Empleador update(Empleador empleador) {
        return empleadorRepository.save(empleador);
    }

    @Override
    public void delete(int id) {
        empleadorRepository.deleteById(id);
    }
}
