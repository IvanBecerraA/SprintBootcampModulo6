package cl.awakelab.sprint6bootcamp.controller;

import cl.awakelab.sprint6bootcamp.entity.Empleador;
import cl.awakelab.sprint6bootcamp.entity.Perfil;
import cl.awakelab.sprint6bootcamp.entity.Usuario;
import cl.awakelab.sprint6bootcamp.service.IEmpleadorService;
import cl.awakelab.sprint6bootcamp.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    IUsuarioService usuarioService;

    @Autowired
    IEmpleadorService empleadorService;

    @GetMapping("/crearUsuario")
    public String mostrarCrearUsuario() {
        return "/crearUsuario";
    }

    @PostMapping("/crearUsuario")
    public String create(@ModelAttribute Usuario usuario, @RequestParam("perfil") int idPerfil, @RequestParam("telefono2") String telefono2) {
        if (!telefono2.isBlank()) {
            usuario.setTelefono(Long.parseLong(telefono2));
        }
        Perfil perfil = new Perfil();
        perfil.setIdPerfil(idPerfil);
        usuario.setPerfil(perfil);
        usuario.setFechaCreacion(LocalDateTime.now());
        usuarioService.create(usuario);

        if (idPerfil == 3) {
            Empleador empleador = new Empleador();
            empleador.setRun(usuario.getRun());
            empleador.setNombre(usuario.getNombre());
            empleador.setApellido1(usuario.getApellido1());
            empleador.setApellido2(usuario.getApellido2());
            empleador.setEmail(usuario.getEmail());
            empleador.setTelefono(usuario.getTelefono());
            empleador.setUsuario(usuario);
            empleadorService.create(empleador);
        }
        return "redirect:/usuario";
    }

    @PostMapping("/registrarUsuario")
    public String register(@ModelAttribute Usuario usuario, @RequestParam("perfil") int idPerfil) {
        Perfil perfil = new Perfil();
        perfil.setIdPerfil(idPerfil);
        usuario.setPerfil(perfil);
        usuario.setFechaCreacion(LocalDateTime.now());
        usuarioService.create(usuario);
        return "redirect:/login";
    }

    @RequestMapping("/obtenerUsuario")
    @ResponseBody
    public Optional<Usuario> readById(int id) {
        return Optional.ofNullable(usuarioService.readById(id));
    }

    @GetMapping
    public String readAll(Model model) {
        model.addAttribute("usuarios", usuarioService.readAll());
        return "listarUsuarios";
    }

    @PostMapping("/editarUsuario")
    public String update(@ModelAttribute Usuario usuario, @RequestParam("perfil") int idPerfil, @RequestParam("telefono2") String telefono2) {

        if (!telefono2.isBlank()) {
            usuario.setTelefono(Long.parseLong(telefono2));
        }
        Perfil perfil = new Perfil();
        perfil.setIdPerfil(idPerfil);
        usuario.setPerfil(perfil);
        usuarioService.update(usuario);

        //Empleador cambia a Contador
        if (idPerfil == 2) {
            List<Empleador> empleadores = empleadorService.readAll();

            empleadores.forEach(empleador -> {
                if (empleador.getUsuario().getIdUsuario() == usuario.getIdUsuario()) {
                    if (empleador.getRun() != usuario.getRun()) {
                        empleadorService.delete(empleador.getIdEmpleador());
                    }
                }
            });
        }

        //Contador cambia a Empleador
        if (idPerfil == 3) {

            AtomicBoolean empleadorExiste = new AtomicBoolean(false);
            List<Empleador> empleadores = empleadorService.readAll();
            empleadores.forEach(empleador -> {
                if (empleador.getRun() == usuario.getRun()) {
                    empleadorExiste.set(true);
                }
            });

            if (!empleadorExiste.get()) {
                Empleador empleador = new Empleador();
                empleador.setRun(usuario.getRun());
                empleador.setNombre(usuario.getNombre());
                empleador.setApellido1(usuario.getApellido1());
                empleador.setApellido2(usuario.getApellido2());
                empleador.setEmail(usuario.getEmail());
                empleador.setTelefono(usuario.getTelefono());
                empleador.setUsuario(usuario);
                empleadorService.create(empleador);
            }
        }

        return "redirect:/usuario";
    }

    @GetMapping("/{id}/eliminarUsuario")
    public String delete(@PathVariable("id") int id) {
        usuarioService.delete(id);
        return "redirect:/usuario";
    }

}
