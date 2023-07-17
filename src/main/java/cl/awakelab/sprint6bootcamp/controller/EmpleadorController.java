package cl.awakelab.sprint6bootcamp.controller;

import cl.awakelab.sprint6bootcamp.entity.Empleador;
import cl.awakelab.sprint6bootcamp.entity.Perfil;
import cl.awakelab.sprint6bootcamp.entity.Usuario;
import cl.awakelab.sprint6bootcamp.service.IEmpleadorService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/empleador")
public class EmpleadorController {

    @Autowired
    IEmpleadorService empleadorService;

    @GetMapping("/crearEmpleador")
    public String mostrarCrearEmpleador() {
        return "/crearEmpleador";
    }

    @PostMapping("/crearEmpleador")
    public String crearEmpleador(@ModelAttribute Empleador empleador, @RequestParam("telefono2") String telefono2, HttpSession session) {
        if (!telefono2.isBlank()) {
            empleador.setTelefono(Long.parseLong(telefono2));
        }
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        empleador.setUsuario(usuario);
        empleadorService.create(empleador);
        return "redirect:/empleador";
    }

    @RequestMapping("/obtenerEmpleador")
    @ResponseBody
    public Optional<Empleador> readById(int id) {
        return Optional.ofNullable(empleadorService.readById(id));
    }

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

    @PostMapping("/editarEmpleador")
    public String update(@ModelAttribute Empleador empleador, @RequestParam("telefono2") String telefono2, @RequestParam("idUsuario") int idUsuario) {

        if (!telefono2.isBlank()) {
            empleador.setTelefono(Long.parseLong(telefono2));
        }
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(idUsuario);
        empleador.setUsuario(usuario);
        empleadorService.update(empleador);
        return "redirect:/empleador";
    }

    @GetMapping("/{id}/eliminarEmpleador")
    public String delete(@PathVariable("id") int id) {
        empleadorService.delete(id);
        return "redirect:/empleador";
    }

}
