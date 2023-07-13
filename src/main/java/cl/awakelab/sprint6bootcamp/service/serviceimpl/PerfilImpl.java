package cl.awakelab.sprint6bootcamp.service.serviceimpl;

import cl.awakelab.sprint6bootcamp.entity.Perfil;
import cl.awakelab.sprint6bootcamp.repository.IPerfilRepository;
import cl.awakelab.sprint6bootcamp.service.IPerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("perfilImpl")
public class PerfilImpl implements IPerfilService {

    @Autowired
    IPerfilRepository perfilRepository;

    @Override
    public Perfil create(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    @Override
    public Perfil readById(int id) {
        return perfilRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Perfil no encontrado"));
    }

    @Override
    public List<Perfil> readAll() {
        return perfilRepository.findAll();
    }

    @Override
    public Perfil update(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    @Override
    public void delete(int id) {
        perfilRepository.deleteById(id);
    }
}
