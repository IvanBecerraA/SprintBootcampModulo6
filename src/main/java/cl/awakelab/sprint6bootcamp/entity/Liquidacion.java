package cl.awakelab.sprint6bootcamp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "liquidacion")
public class Liquidacion {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLiquidacion;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_trabajador", nullable = false)
    private Trabajador trabajador;

    @Column(nullable = false)
    private LocalDate periodo;
    @Column(nullable = false)
    private int sueldoImponible;
    @Column(nullable = false)
    private int sueldoLiquido;


    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_inst_salud", nullable = false)
    private InstitucionSalud institucionSalud;

    @Column(nullable = false)
    private int montoInstSalud;


    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_inst_prevision", nullable = false)
    private InstitucionPrevision institucionPrevision;

    @Column(nullable = false)
    private int montoInstPrevision;
    @Column(nullable = false)
    private int totalDescuento;
    @Column(nullable = false)
    private int totalHaberes;
    @Column(nullable = false)
    private int anticipo;

}