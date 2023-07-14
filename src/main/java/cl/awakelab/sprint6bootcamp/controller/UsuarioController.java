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

    @PostMapping("/crearUsuario")
    public String create(@ModelAttribute Usuario usuario, @RequestParam("perfil") int idPerfil) {
        Perfil perfil = new Perfil();
        perfil.setIdPerfil(idPerfil);
        usuario.setPerfil(perfil);
        usuario.setFechaCreacion(LocalDateTime.now());
        usuarioService.create(usuario);
        return "redirect:/usuario";
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
    public String update(@ModelAttribute Usuario usuario, @RequestParam("perfil") int idPerfil) {
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
