package cl.awakelab.sprint6bootcamp.controller;

import cl.awakelab.sprint6bootcamp.service.ITrabajadorService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/trabajador")
public class TrabajadorController {

    @Autowired
    ITrabajadorService trabajadorService;

    @GetMapping()
    public String readAll(Model model, HttpSession session) {
        model.addAttribute("trabajadores", trabajadorService.readAll(session));
        return "listarTrabajadores";
    }

}
