package cl.awakelab.sprint6bootcamp.controller;

import cl.awakelab.sprint6bootcamp.entity.Trabajador;
import cl.awakelab.sprint6bootcamp.service.ITrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trabajador")
public class TrabajadorController {

    @Autowired
    ITrabajadorService trabajadorService;

    @PostMapping
    public Trabajador create(@RequestBody Trabajador trabajador) {
        return trabajadorService.create(trabajador);
    }

    @GetMapping("/{id}")
    public Trabajador readById(@PathVariable int id) {
        return trabajadorService.readById(id);
    }

    @GetMapping
    public List<Trabajador> readAll() {
        return trabajadorService.readAll();
    }

    @PutMapping
    public Trabajador update(@RequestBody Trabajador trabajador) {
        return trabajadorService.update(trabajador);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        trabajadorService.delete(id);
    }

}
