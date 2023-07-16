package cl.awakelab.sprint6bootcamp.restcontroller;

import cl.awakelab.sprint6bootcamp.entity.Empleador;
import cl.awakelab.sprint6bootcamp.service.IEmpleadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleador")
public class EmpleadorRestController {

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
