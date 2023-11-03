package tp.tp_backend.entities.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarifasDto {
    private Long tipoTarifa;
    private String definicion;
    private Long diaSemana;
    private Long diaMes;
    private Long mes;
    private Long anio;
    private Double montoFijoAlquiler;
    private Double montoMinutoFraccion;
    private Double montoKm;
    private Double montoHora;
}
