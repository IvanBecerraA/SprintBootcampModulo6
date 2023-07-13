package cl.awakelab.sprint6bootcamp.service.serviceimpl;

import cl.awakelab.sprint6bootcamp.entity.InstitucionPrevision;
import cl.awakelab.sprint6bootcamp.repository.IInstitucionPrevisionRepository;
import cl.awakelab.sprint6bootcamp.service.IInstitucionPrevicionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("institucionPrevisionImpl")
public class InstitucionPrevisionImpl implements IInstitucionPrevicionService {

    @Autowired
    IInstitucionPrevisionRepository institucionPrevisionRepository;

    @Override
    public InstitucionPrevision create(InstitucionPrevision institucionPrevision) {
        return institucionPrevisionRepository.save(institucionPrevision);
    }

    @Override
    public InstitucionPrevision readById(int id) {
        return institucionPrevisionRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Institución Previsión no encontrado"));
    }

    @Override
    public List<InstitucionPrevision> readAll() {
        return institucionPrevisionRepository.findAll();
    }

    @Override
    public InstitucionPrevision update(InstitucionPrevision institucionPrevision) {
        return institucionPrevisionRepository.save(institucionPrevision);
    }

    @Override
    public void delete(int id) {
        institucionPrevisionRepository.deleteById(id);
    }
}
