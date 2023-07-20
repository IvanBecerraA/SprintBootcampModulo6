package cl.awakelab.sprint6bootcamp.service.serviceimpl;

import cl.awakelab.sprint6bootcamp.entity.Empleador;
import cl.awakelab.sprint6bootcamp.entity.Trabajador;
import cl.awakelab.sprint6bootcamp.entity.Usuario;
import cl.awakelab.sprint6bootcamp.repository.IEmpleadorRepository;
import cl.awakelab.sprint6bootcamp.service.IEmpleadorService;
import cl.awakelab.sprint6bootcamp.service.ITrabajadorService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service("empleadorImpl")
public class EmpleadorImpl implements IEmpleadorService {

    @Autowired
    IEmpleadorRepository empleadorRepository;
    @Autowired
    ITrabajadorService trabajadorService;


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
    public List<Empleador> readByUser(Usuario usuario) {
        List<Empleador> empleadores = empleadorRepository.findAll();

        if (usuario.getPerfil().getIdPerfil() == 1) {
            return empleadores;
        } else if (usuario.getPerfil().getIdPerfil() == 2) {
            List<Empleador> empleadoresContador = new ArrayList<>();
            for (Empleador empleador : empleadores) {
                if (empleador.getUsuario().getIdUsuario() == usuario.getIdUsuario()) {
                    empleadoresContador.add(empleador);
                }
            }
            return empleadoresContador;
        } else if (usuario.getPerfil().getIdPerfil() == 3) {
            List<Empleador> empleadoresUno = new ArrayList<>();
            for (Empleador empleador : empleadores) {
                if (empleador.getUsuario().getIdUsuario() == usuario.getIdUsuario()) {
                    empleadoresUno.add(empleador);
                }
            }
            return empleadoresUno;
        } else {
            return null;
        }
    }

    @Override
    public Empleador update(Empleador empleador) {
        return empleadorRepository.save(empleador);
    }

    @Override
    public void delete(int id) {
        Empleador empleador = this.readById(id);
        List<Trabajador> trabajadoresEmpleadoresUsuario = empleador.getListaTrabajadores();
        for (Trabajador trabajador : trabajadoresEmpleadoresUsuario) {
            trabajadorService.delete(trabajador.getIdTrabajador());
        }

        empleadorRepository.deleteById(id);
    }
}
