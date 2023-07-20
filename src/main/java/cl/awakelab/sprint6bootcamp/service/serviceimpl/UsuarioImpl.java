package cl.awakelab.sprint6bootcamp.service.serviceimpl;

import cl.awakelab.sprint6bootcamp.entity.Empleador;
import cl.awakelab.sprint6bootcamp.entity.Trabajador;
import cl.awakelab.sprint6bootcamp.entity.Usuario;
import cl.awakelab.sprint6bootcamp.repository.IUsuarioRepository;
import cl.awakelab.sprint6bootcamp.service.IEmpleadorService;
import cl.awakelab.sprint6bootcamp.service.ITrabajadorService;
import cl.awakelab.sprint6bootcamp.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("usuarioImpl")
public class UsuarioImpl implements IUsuarioService {

    @Autowired
    IUsuarioRepository usuarioRepository;
    @Autowired
    IEmpleadorService empleadorService;
    @Autowired
    ITrabajadorService trabajadorService;


    @Override
    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario readById(int id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Usuario no encontrado"));
    }

    @Override
    public List<Usuario> readAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario update(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void delete(int id) {
        Usuario usuario = this.readById(id);
        List<Empleador> empleadoresUsuario = empleadorService.readByUser(usuario);
        for (Empleador empleador : empleadoresUsuario) {
            List<Trabajador> trabajadoresEmpleadoresUsuario = empleador.getListaTrabajadores();
            for (Trabajador trabajador : trabajadoresEmpleadoresUsuario) {
                trabajadorService.delete(trabajador.getIdTrabajador());
            }
        }

        usuarioRepository.deleteById(id);

    }
}
