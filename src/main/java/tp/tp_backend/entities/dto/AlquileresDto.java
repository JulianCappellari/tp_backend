package tp.tp_backend.entities.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlquileresDto {
    private Long id;
    private Long idCliente;
    private Long estado;
    private Long estadoRetiro;
    private Long estadoDevolucion;
    private Timestamp fechaHoraRetiro;
    private Timestamp fechaHoraDevolucion;
    private Long monto;
    private String idTarifa;
}
