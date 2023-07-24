package cl.awakelab.sprint6bootcamp.service.serviceimpl;

import cl.awakelab.sprint6bootcamp.entity.Empleador;
import cl.awakelab.sprint6bootcamp.entity.Liquidacion;
import cl.awakelab.sprint6bootcamp.entity.Trabajador;
import cl.awakelab.sprint6bootcamp.entity.Usuario;
import cl.awakelab.sprint6bootcamp.repository.IEmpleadorRepository;
import cl.awakelab.sprint6bootcamp.repository.ILiquidacionRepository;
import cl.awakelab.sprint6bootcamp.repository.ITrabajadorRepository;
import cl.awakelab.sprint6bootcamp.service.IInstitucionPrevicionService;
import cl.awakelab.sprint6bootcamp.service.IInstitucionSaludService;
import cl.awakelab.sprint6bootcamp.service.ILiquidacionService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service("liquidacionImpl")
public class LiquidacionImpl implements ILiquidacionService {

    @Autowired
    ILiquidacionRepository liquidacionRepository;

    @Autowired
    IEmpleadorRepository empleadorRepository;

    @Autowired
    ITrabajadorRepository trabajadorRepository;

    @Autowired
    IInstitucionPrevicionService institucionPrevicionService;

    @Autowired
    IInstitucionSaludService institucionSaludService;

    @Override
    public Liquidacion create(Liquidacion liquidacion) {

        liquidacion.setTotalHaberes(liquidacion.getSueldoImponible());
        liquidacion.setInstitucionSalud(
                liquidacion.getTrabajador().getInstitucionSalud());
        liquidacion.setMontoInstSalud(
                ( (int) (liquidacion.getSueldoImponible()
                        * liquidacion.getTrabajador().getInstitucionSalud().getPorcDcto()) )/100);
        liquidacion.setInstitucionPrevision(
                liquidacion.getTrabajador().getInstitucionPrevision());
        liquidacion.setMontoInstPrevision(
                ( (int) (liquidacion.getSueldoImponible()
                        * liquidacion.getTrabajador().getInstitucionPrevision().getPorcDcto()) )/100);
        liquidacion.setTotalDescuento(liquidacion.getMontoInstSalud() + liquidacion.getMontoInstPrevision());
        liquidacion.setSueldoLiquido(liquidacion.getTotalHaberes() - liquidacion.getTotalDescuento() - liquidacion.getAnticipo());

        return liquidacionRepository.save(liquidacion);
    }

    @Override
    public Liquidacion readById(int id) {
        return liquidacionRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Liquidación no encontrada"));
    }

    @Override
    public List<Liquidacion> readAll() {
        return liquidacionRepository.findAll();
    }

    @Override
    public List<Liquidacion> readByUser(HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        List<Liquidacion> liquidaciones = liquidacionRepository.findAll();
        List<Empleador> empleadores = empleadorRepository.findAll();
        List<Trabajador> trabajadores = new ArrayList<>();


        if (usuario.getPerfil().getIdPerfil() == 1) {
            return liquidaciones;
        } else if (usuario.getPerfil().getIdPerfil() == 2) {
            List<Liquidacion> liquidacionesEmpleador = new ArrayList<>();
            for (Empleador empleador : empleadores) {
                if (empleador.getUsuario().getIdUsuario() == usuario.getIdUsuario()) {
                    trabajadores = empleador.getListaTrabajadores();
                    for (Trabajador trabajador : trabajadores) {
                        List<Liquidacion> liquidacionesAux = trabajador.getListaLiquidaciones();
                        for (Liquidacion liquidacion : liquidacionesAux) {
                            if (!liquidacionesEmpleador.contains(liquidacion)) {
                                liquidacionesEmpleador.add(liquidacion);
                            }
                        }
                    }
                }
            }
            return liquidacionesEmpleador;
        } else if (usuario.getPerfil().getIdPerfil() == 3) {
            List<Liquidacion> liquidacionesEmpleador = new ArrayList<>();
            for (Empleador empleador : empleadores) {
                if (empleador.getUsuario().getIdUsuario() == usuario.getIdUsuario()) {
                    trabajadores = empleador.getListaTrabajadores();
                    for (Trabajador trabajador : trabajadores) {
                        List<Liquidacion> liquidacionesAux = trabajador.getListaLiquidaciones();
                        for (Liquidacion liquidacion : liquidacionesAux) {
                            liquidacionesEmpleador.add(liquidacion);
                        }
                    }
                }
            }
            return liquidacionesEmpleador;
        } else {
            return null;
        }

    }

    @Override
    public Liquidacion update(Liquidacion liquidacion) {
        return liquidacionRepository.save(liquidacion);
    }

    @Override
    public void delete(int id) {
        liquidacionRepository.deleteById(id);
    }
}
