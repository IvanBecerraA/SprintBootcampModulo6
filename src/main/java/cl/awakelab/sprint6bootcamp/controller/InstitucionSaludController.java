package cl.awakelab.sprint6bootcamp.controller;

import cl.awakelab.sprint6bootcamp.entity.InstitucionSalud;
import cl.awakelab.sprint6bootcamp.service.IInstitucionSaludService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/institucionSalud")
public class InstitucionSaludController {

    @Autowired
    IInstitucionSaludService institucionSaludService;

    @PostMapping
    public InstitucionSalud create(@RequestBody InstitucionSalud institucionSalud) {
        return institucionSaludService.create(institucionSalud);
    }

    @GetMapping("/{id}")
    public InstitucionSalud readById(@PathVariable int id) {
        return institucionSaludService.readById(id);
    }

    @GetMapping
    public List<InstitucionSalud> readAll() {
        return institucionSaludService.readAll();
    }

    @PutMapping
    public InstitucionSalud update(@RequestBody InstitucionSalud institucionSalud) {
        return institucionSaludService.update(institucionSalud);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        institucionSaludService.delete(id);
    }

}
