package cl.awakelab.sprint6bootcamp.controller;

import cl.awakelab.sprint6bootcamp.entity.Empleador;
import cl.awakelab.sprint6bootcamp.entity.Trabajador;
import cl.awakelab.sprint6bootcamp.service.IEmpleadorService;
import cl.awakelab.sprint6bootcamp.service.IInstitucionPrevicionService;
import cl.awakelab.sprint6bootcamp.service.IInstitucionSaludService;
import cl.awakelab.sprint6bootcamp.service.ITrabajadorService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
        model.addAttribute("empleadores", empleadorService.readByUser(session));
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
        model.addAttribute("trabajadores", trabajadorService.readAll(session));
        return "listarTrabajadores";
    }

    @GetMapping("/{id}/eliminarTrabajador")
    public String delete(@PathVariable("id") int id) {
        trabajadorService.delete(id);
        return "redirect:/trabajador";
    }

}
