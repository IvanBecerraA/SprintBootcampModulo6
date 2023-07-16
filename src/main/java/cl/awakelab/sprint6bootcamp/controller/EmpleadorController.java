package cl.awakelab.sprint6bootcamp.controller;

import cl.awakelab.sprint6bootcamp.entity.Empleador;
import cl.awakelab.sprint6bootcamp.service.IEmpleadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/empleador")
public class EmpleadorController {

    @Autowired
    IEmpleadorService empleadorService;

    @GetMapping("/crearEmpleador")
    public String mostrarCrearEmpleador() {
        return "crearEmpleador";
    }

    /*
    @PostMapping("/crearEmpleador")
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
    }*/
}
