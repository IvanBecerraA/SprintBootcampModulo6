package cl.awakelab.sprint6bootcamp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MenuController {
    @GetMapping("/menu")
    public String menuGet() {
        return "menu";
    }

    @PostMapping("/menu")
    public String menu() {
        // crear lógica para confirmar los datos del usuario,
        // guardar el tipo de usuario para mostrar las acciones de cada tipo
        return "menu";
    }
}
