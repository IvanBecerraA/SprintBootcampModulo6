package cl.awakelab.sprint6.controller;

import cl.awakelab.sprint6.entity.Empleador;
import cl.awakelab.sprint6.service.IEmpleadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleador")
public class EmpleadorController {

    @Autowired
    IEmpleadorService empleadorService;

    @PostMapping
    public Empleador create(@RequestBody Empleador empleador) {
        return empleadorService.create(empleador);
    }

    @GetMapping("/{id}")
    public Empleador readById(@PathVariable int id) {
        return empleadorService.readById(id);
    }

    @GetMapping
    public List<Empleador> readAll() {
        return empleadorService.readAll();
    }

    @PutMapping
    public Empleador update(@RequestBody Empleador empleador) {
        return empleadorService.update(empleador);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        empleadorService.delete(id);
    }
}
