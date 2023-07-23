package cl.awakelab.sprint6bootcamp.restcontroller;

import cl.awakelab.sprint6bootcamp.entity.Liquidacion;
import cl.awakelab.sprint6bootcamp.service.ILiquidacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/liquidacion")
public class LiquidacionRestController {

    @Autowired
    ILiquidacionService liquidacionService;

    @PostMapping
    public Liquidacion create(@RequestBody Liquidacion liquidacion) {
        return liquidacionService.create(liquidacion);
    }

    @GetMapping("/{id}")
    public Liquidacion readById(@PathVariable int id) {
        return liquidacionService.readById(id);
    }

    @GetMapping
    public List<Liquidacion> readAll() {
        return liquidacionService.readAll();
    }

    @PutMapping
    public Liquidacion update(@RequestBody Liquidacion liquidacion) {
        return liquidacionService.update(liquidacion);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        liquidacionService.delete(id);
    }

}
