package cl.awakelab.sprint6bootcamp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistroController {
    @GetMapping("/registro")
    public String registro() {
        return "registro";
    }

}
