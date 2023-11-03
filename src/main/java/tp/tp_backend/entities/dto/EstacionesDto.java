package tp.tp_backend.entities.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstacionesDto {
    private Long id;
    private String nombre;
    private Timestamp dateCreacion;
    private Double latitud;
    private Double longitud;
}
