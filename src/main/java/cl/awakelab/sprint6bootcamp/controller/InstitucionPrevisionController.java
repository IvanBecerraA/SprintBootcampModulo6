package cl.awakelab.sprint6bootcamp.controller;

import cl.awakelab.sprint6bootcamp.entity.InstitucionPrevision;
import cl.awakelab.sprint6bootcamp.service.IInstitucionPrevicionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/institucionPrevision")
public class InstitucionPrevisionController {

    @Autowired
    IInstitucionPrevicionService institucionPrevicionService;

    @PostMapping
    public InstitucionPrevision create(@RequestBody InstitucionPrevision institucionPrevicion) {
        return institucionPrevicionService.create(institucionPrevicion);
    }

    @GetMapping("/{id}")
    public InstitucionPrevision readById(@PathVariable int id) {
        return institucionPrevicionService.readById(id);
    }

    @GetMapping
    public List<InstitucionPrevision> readAll() {
        return institucionPrevicionService.readAll();
    }

    @PutMapping
    public InstitucionPrevision update(@RequestBody InstitucionPrevision institucionPrevicion) {
        return institucionPrevicionService.update(institucionPrevicion);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        institucionPrevicionService.delete(id);
    }

}
