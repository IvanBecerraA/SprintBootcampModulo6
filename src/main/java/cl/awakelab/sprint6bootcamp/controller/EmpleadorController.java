package cl.awakelab.sprint6bootcamp.controller;

import cl.awakelab.sprint6bootcamp.entity.Empleador;
import cl.awakelab.sprint6bootcamp.entity.Usuario;
import cl.awakelab.sprint6bootcamp.service.IEmpleadorService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/empleador")
public class EmpleadorController {

    @Autowired
    IEmpleadorService empleadorService;

    @GetMapping
    public String readAll(Model model, HttpSession session) {

        List<Empleador> empleadores = empleadorService.readAll();
        List<Empleador> empleadoresDelUsuario = new ArrayList<>();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        for (Empleador empleador : empleadores) {
            if (empleador.getUsuario().getIdUsuario() == usuario.getIdUsuario()) {
                empleadoresDelUsuario.add(empleador);
            }
        }

        model.addAttribute("empleadores", empleadoresDelUsuario);
        return "listarEmpleadores";
    }

    @GetMapping("/{id}/eliminarEmpleador")
    public String delete(@PathVariable("id") int id) {
        empleadorService.delete(id);
        return "redirect:/empleador";
    }
    
    /*
    @GetMapping("/crearEmpleador")
    public String mostrarCrearEmpleador() {
        return "crearEmpleador";
    }

    
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
