package tp.tp_backend.entities;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "tarifas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarifas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TIPO_TARIFA")
    private Long tipoTarifa;

    @Column(name = "DEFINICION")
    private String definicion;

    @Column(name = "DIA_SEMANA")
    private Long diaSemana;

    @Column(name = "DIA_MES")
    private Long diaMes;

    @Column(name = "MES")
    private Long mes;

    @Column(name = "ANIO")
    private Long anio;

    @Column(name = "MONTO_FIJO_ALQUILER")
    private Double montoFijoAlquiler;

    @Column(name = "MONTO_MINUTO_FRACCION")
    private Double montoMinutoFraccion;

    @Column(name = "MONTO_KM")
    private Double montoKm;

    @Column(name = "MONTO_HORA")
    private Double montoHora;

    // Constructor con todas las propiedades
    public Tarifas(Long tipoTarifa, String definicion, Long diaSemana, Long diaMes, Long mes, Long anio, Double montoFijoAlquiler, Double montoMinutoFraccion, Double montoKm, Double montoHora) {
        this.tipoTarifa = tipoTarifa;
        this.definicion = definicion;
        this.diaSemana = diaSemana;
        this.diaMes = diaMes;
        this.mes = mes;
        this.anio = anio;
        this.montoFijoAlquiler = montoFijoAlquiler;
        this.montoMinutoFraccion = montoMinutoFraccion;
        this.montoKm = montoKm;
        this.montoHora = montoHora;
    }
}
