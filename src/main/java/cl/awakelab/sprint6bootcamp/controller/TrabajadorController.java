package cl.awakelab.sprint6bootcamp.controller;

import cl.awakelab.sprint6bootcamp.entity.Trabajador;
import cl.awakelab.sprint6bootcamp.entity.Usuario;
import cl.awakelab.sprint6bootcamp.service.IEmpleadorService;
import cl.awakelab.sprint6bootcamp.service.IInstitucionPrevicionService;
import cl.awakelab.sprint6bootcamp.service.IInstitucionSaludService;
import cl.awakelab.sprint6bootcamp.service.ITrabajadorService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/trabajador")
public class TrabajadorController {

    @Autowired
    ITrabajadorService trabajadorService;

    @Autowired
    IEmpleadorService empleadorService;

    @Autowired
    IInstitucionSaludService institucionSaludService;

    @Autowired
    IInstitucionPrevicionService institucionPrevicionService;

    @GetMapping("/crearTrabajador")
    public String mostrarCrearTrabajador(Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        model.addAttribute("empleadores", empleadorService.readByUser(usuario));
        model.addAttribute("institucionesSalud", institucionSaludService.readAll());
        model.addAttribute("institucionesPrevision", institucionPrevicionService.readAll());
        return "/crearTrabajador";
    }
    /*
    //Crea el trabajador con un solo empleador
    @PostMapping("/crearTrabajador")
    public String crearTrabajador(@ModelAttribute Trabajador trabajador, @ModelAttribute Empleador empleador) {
        trabajadorService.create(trabajador, empleador);
        return "redirect:/trabajador";
    }*/
    @PostMapping("/crearTrabajador")
    public String crearTrabajador(@ModelAttribute Trabajador trabajador, @RequestParam(value = "listaEmpleadores", required = false) List<Integer> listaEmpleadoresSeleccionados) {
        trabajadorService.create(trabajador, listaEmpleadoresSeleccionados);
        return "redirect:/trabajador";
    }

    @GetMapping()
    public String readAll(Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        model.addAttribute("empleadores", empleadorService.readByUser(usuario));
        model.addAttribute("trabajadores", trabajadorService.readAll(session));
        model.addAttribute("institucionesSalud", institucionSaludService.readAll());
        model.addAttribute("institucionesPrevision", institucionPrevicionService.readAll());
        return "listarTrabajadores";
    }

    @GetMapping("/obtenerTrabajador")
    @ResponseBody
    public Optional<Trabajador> readById(int id) {
        Trabajador trabajador = trabajadorService.readById(id);
        return Optional.ofNullable(trabajador);
    }

    @PostMapping("/editarTrabajador")
    public String update(@ModelAttribute Trabajador trabajador, @RequestParam(value = "listaEmpleadores", required = false) List<Integer> listaEmpleadoresSeleccionados) {
        trabajadorService.update(trabajador, listaEmpleadoresSeleccionados);
        return "redirect:/trabajador";
    }

    @GetMapping("/{id}/eliminarTrabajador")
    public String delete(@PathVariable("id") int id) {
        trabajadorService.delete(id);
        return "redirect:/trabajador";
    }

}
