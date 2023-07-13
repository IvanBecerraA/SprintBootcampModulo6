package cl.awakelab.sprint6bootcamp.controller;

import cl.awakelab.sprint6bootcamp.entity.Usuario;
import cl.awakelab.sprint6bootcamp.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    IUsuarioService usuarioService;

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {
        return usuarioService.create(usuario);
    }

    @GetMapping("/{id}")
    public Usuario readById(@PathVariable int id) {
        return usuarioService.readById(id);
    }

    @GetMapping
    public List<Usuario> readAll() {
        return usuarioService.readAll();
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
