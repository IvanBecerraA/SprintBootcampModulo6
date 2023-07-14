package cl.awakelab.sprint6bootcamp.controller;

import cl.awakelab.sprint6bootcamp.entity.Usuario;
import cl.awakelab.sprint6bootcamp.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    IUsuarioService usuarioService;

    @PostMapping("/crearUsuario")
    public String create(@ModelAttribute Usuario usuario) {
        usuarioService.create(usuario);
        return "redirect:/usuario";
    }

    @GetMapping("/{id}")
    public Usuario readById(@PathVariable int id) {
        return usuarioService.readById(id);
    }

    @GetMapping
    public String readAll(Model model) {
        model.addAttribute("usuarios", usuarioService.readAll());
        return "listarUsuarios";
    }

    @PutMapping
    public Usuario update(@RequestBody Usuario usuario) {
        return usuarioService.update(usuario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        usuarioService.delete(id);
    }

}
