package cl.awakelab.sprint6bootcamp.controller;

import cl.awakelab.sprint6bootcamp.entity.Perfil;
import cl.awakelab.sprint6bootcamp.entity.Usuario;
import cl.awakelab.sprint6bootcamp.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    IUsuarioService usuarioService;

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
        System.out.println("editarUsuario");
        Perfil perfil = new Perfil();
        perfil.setIdPerfil(idPerfil);
        usuario.setPerfil(perfil);
        usuario.setFechaCreacion(LocalDateTime.now());
        usuarioService.update(usuario);
        return "redirect:/usuario";
    }

    @GetMapping("/{id}/eliminarUsuario")
    public String delete(@PathVariable("id") int id) {
        usuarioService.delete(id);
        return "redirect:/usuario";
    }

}
