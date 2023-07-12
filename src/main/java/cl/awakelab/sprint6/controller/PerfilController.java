package cl.awakelab.sprint6.controller;

import cl.awakelab.sprint6.entity.Perfil;
import cl.awakelab.sprint6.service.IPerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    IPerfilService perfilService;

    @PostMapping
    public Perfil create(@RequestBody Perfil perfil) {
        return perfilService.create(perfil);
    }

    @GetMapping("/{id}")
    public Perfil readById(@PathVariable int id) {
        return perfilService.readById(id);
    }

    @GetMapping
    public List<Perfil> readAll() {
        return perfilService.readAll();
    }

    @PutMapping
    public Perfil update(@RequestBody Perfil perfil) {
        return perfilService.update(perfil);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        perfilService.delete(id);
    }



}
