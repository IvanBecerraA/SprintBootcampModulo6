package cl.awakelab.sprint6bootcamp.service.serviceimpl;

import cl.awakelab.sprint6bootcamp.entity.Empleador;
import cl.awakelab.sprint6bootcamp.entity.Trabajador;
import cl.awakelab.sprint6bootcamp.entity.Usuario;
import cl.awakelab.sprint6bootcamp.repository.IEmpleadorRepository;
import cl.awakelab.sprint6bootcamp.repository.ITrabajadorRepository;
import cl.awakelab.sprint6bootcamp.repository.IUsuarioRepository;
import cl.awakelab.sprint6bootcamp.service.IEmpleadorService;
import cl.awakelab.sprint6bootcamp.service.ITrabajadorService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service("trabajadorImpl")
public class TrabajadorImpl implements ITrabajadorService {

    @Autowired
    ITrabajadorRepository trabajadorRepository;

    @Autowired
    IUsuarioRepository usuarioRepository;

    @Autowired
    IEmpleadorRepository empleadorRepository;

    @Override
    public Trabajador create(Trabajador trabajador) {
        return trabajadorRepository.save(trabajador);
    }

    @Override
    public Trabajador create(Trabajador trabajador, Empleador empleador) {
        List<Empleador> empleadores = new ArrayList<>();
        if (trabajador.getListaEmpleadores() != null) {
            empleadores = trabajador.getListaEmpleadores();
        }
        empleadores.add(empleador);
        trabajador.setListaEmpleadores(empleadores);
        return trabajadorRepository.save(trabajador);
    }

    @Override
    public Trabajador create(Trabajador trabajador, List<Integer> listaEmpleadoresSeleccionados) {
        if (listaEmpleadoresSeleccionados != null && !listaEmpleadoresSeleccionados.isEmpty()) {
            List<Empleador> empleadoresSeleccionados = new ArrayList<>();
            for (Integer idEmpleador : listaEmpleadoresSeleccionados) {
                Empleador empleador = empleadorRepository.findById(idEmpleador).orElseThrow(() -> new NoSuchElementException("Empleador no encontrado"));
                empleadoresSeleccionados.add(empleador);
            }
            trabajador.setListaEmpleadores(empleadoresSeleccionados);
        }

        return trabajadorRepository.save(trabajador);
    }

    @Override
    public Trabajador readById(int id) {
        return trabajadorRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Trabajador no encontrado"));
    }

    @Override
    public List<Trabajador> readAll() {
        List<Trabajador> trabajadores = trabajadorRepository.findAll();
        return trabajadores;
    }

    @Override
    public List<Trabajador> readByUser(HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        List<Trabajador> trabajadores = trabajadorRepository.findAll();
        List<Empleador> empleadores = empleadorRepository.findAll();

        if (usuario.getPerfil().getIdPerfil() == 1) {
            return trabajadores;
        } else if (usuario.getPerfil().getIdPerfil() == 2) {
            List<Trabajador> trabajadoresEmpleadoresContador = new ArrayList<>();
            for (Empleador empleador : empleadores) {
                if (empleador.getUsuario().getIdUsuario() == usuario.getIdUsuario()) {
                    List<Trabajador> trabajadoresAux = empleador.getListaTrabajadores();
                    for (Trabajador trabajador : trabajadoresAux) {
                        if (!trabajadoresEmpleadoresContador.contains(trabajador)){
                            trabajadoresEmpleadoresContador.add(trabajador);
                        }
                    }
                }
            }
            return trabajadoresEmpleadoresContador;
        } else if (usuario.getPerfil().getIdPerfil() == 3) {
            for (Empleador empleador : empleadores) {
                if (empleador.getUsuario().getIdUsuario() == usuario.getIdUsuario()) {
                    trabajadores = empleador.getListaTrabajadores();
                }
            }
            return trabajadores;
        } else {
            return null;
        }
    }

    @Override
    public List<Trabajador> readByEmployer(Empleador empleador) {
        return null;
    }

    @Override
    public Trabajador update(Trabajador trabajador) {
        return trabajadorRepository.save(trabajador);
    }

    @Override
    public Trabajador update(Trabajador trabajador, List<Integer> listaEmpleadoresSeleccionados) {
        if (listaEmpleadoresSeleccionados != null && !listaEmpleadoresSeleccionados.isEmpty()) {
            List<Empleador> empleadoresSeleccionados = new ArrayList<>();
            for (Integer idEmpleador : listaEmpleadoresSeleccionados) {
                Empleador empleador = empleadorRepository.findById(idEmpleador).orElseThrow(() -> new NoSuchElementException("Empleador no encontrado"));
                empleadoresSeleccionados.add(empleador);
            }
            trabajador.setListaEmpleadores(empleadoresSeleccionados);
        }

        return trabajadorRepository.save(trabajador);
    }

    @Override
    public void delete(int id) {
        trabajadorRepository.deleteById(id);
    }
}
