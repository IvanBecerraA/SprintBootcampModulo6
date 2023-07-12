package cl.awakelab.sprint6.controller;

import cl.awakelab.sprint6.entity.Liquidacion;
import cl.awakelab.sprint6.service.ILiquidacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/liquidacion")
public class LiquidacionController {

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
