package cl.awakelab.sprint6bootcamp.controller;

import cl.awakelab.sprint6bootcamp.entity.Liquidacion;
import cl.awakelab.sprint6bootcamp.entity.Trabajador;
import cl.awakelab.sprint6bootcamp.entity.Usuario;
import cl.awakelab.sprint6bootcamp.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/liquidacion")
public class LiquidacionController {

    @Autowired
    ILiquidacionService liquidacionService;

    @Autowired
    ITrabajadorService trabajadorService;

    @Autowired
    IInstitucionSaludService institucionSaludService;

    @Autowired
    IInstitucionPrevicionService institucionPrevicionService;

    @GetMapping()
    public String realAll(Model model, HttpSession session) {
        model.addAttribute("trabajadores", trabajadorService.readByUser(session));
        model.addAttribute("institucionesSalud", institucionSaludService.readAll());
        model.addAttribute("institucionesPrevision", institucionPrevicionService.readAll());
        model.addAttribute("liquidaciones", liquidacionService.readByUser(session));
        return "listarLiquidaciones";
    }

    @GetMapping("/crearLiquidacion")
    public String mostrarCrearLiquidacion(Model model, HttpSession session) {
        model.addAttribute("trabajadores", trabajadorService.readByUser(session));
        return "crearLiquidacion";
    }

    @PostMapping("/crearLiquidacion")
    public String createLiquidacion(@ModelAttribute Liquidacion liquidacion) {
        liquidacionService.create(liquidacion);
        return "redirect:/liquidacion";
    }

    @GetMapping("/{id}/editarLiquidacion")
    public String mostrarEditarLiquidacion(@PathVariable("id") int id, Model model) {
        model.addAttribute("liquidacion", liquidacionService.readById(id));
        return "editarLiquidacion";
    }

    @PostMapping("/editarLiquidacion")
    public String update(@ModelAttribute Liquidacion liquidacion) {
        liquidacionService.update(liquidacion);
        return "redirect:/liquidacion";
    }

    @GetMapping("/{id}/eliminarLiquidacion")
    public String delete(@PathVariable("id") int id) {
        liquidacionService.delete(id);
        return "redirect:/liquidacion";
    }

}
