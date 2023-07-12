package cl.awakelab.sprint6.service.serviceimpl;

import cl.awakelab.sprint6.entity.InstitucionSalud;
import cl.awakelab.sprint6.repository.IInstitucionSaludRepository;
import cl.awakelab.sprint6.service.IInstitucionSaludService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("institucionSaludImpl")
public class InstitucionSaludImpl implements IInstitucionSaludService {

    @Autowired
    IInstitucionSaludRepository institucionSaludRepository;

    @Override
    public InstitucionSalud create(InstitucionSalud institucionSalud) {
        return institucionSaludRepository.save(institucionSalud);
    }

    @Override
    public InstitucionSalud readById(int id) {
        return institucionSaludRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Institución Salud no encontrado"));
    }

    @Override
    public List<InstitucionSalud> readAll() {
        return institucionSaludRepository.findAll();
    }

    @Override
    public InstitucionSalud update(InstitucionSalud institucionSalud) {
        return institucionSaludRepository.save(institucionSalud);
    }

    @Override
    public void delete(int id) {
        institucionSaludRepository.deleteById(id);
    }
}
