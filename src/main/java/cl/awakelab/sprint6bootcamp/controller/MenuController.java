package cl.awakelab.sprint6bootcamp.controller;

import cl.awakelab.sprint6bootcamp.entity.Usuario;
import cl.awakelab.sprint6bootcamp.service.IUsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MenuController {

    @Autowired
    IUsuarioService usuarioService;

    @GetMapping("/menu")
    public String menuGet() {
        return "menu";
    }

    @PostMapping("/menu")
    public String menu(@RequestParam("run") int run, @RequestParam("clave") String clave, HttpSession session, Model model) {
        //
        List<Usuario> usuarios = usuarioService.readAll();

        for (Usuario usuario : usuarios) {
            if (usuario.getRun() == run && usuario.getClave().equals(clave)) {
                session.setAttribute("usuario", usuario);
                return "menu";
            }
        }
        return "login";
    }
}
