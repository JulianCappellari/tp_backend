package tp.tp_backend.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

@Entity(name = "alquileres")
@Data
@NoArgsConstructor

public class Alquileres {
    @Id
    @GeneratedValue(generator = "alquileres")
    @TableGenerator(name = "alquileres", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="alquileres", allocationSize=1)

    @Column(name = "ID")
    private Long id;

    @Column(name = "ID_CLIENTE")
    private Long idCliente;

    @Column(name = "ESTADO", nullable = false)
    private Long estado;

    @Column(name = "ESTADO_RETIRO", nullable = false)
    private Long estadoRetiro;

    @Column(name = "ESTADO_DEVOLUCION")
    private Long estadoDevolucion;

    @Column(name = "FECHA_HORA_RETIRO")
    private Timestamp fechaHoraRetiro;

    @Column(name = "FECHA_HORA_DEVOLUCION")
    private Timestamp fechaHoraDevolucion;

    @Column(name = "MONTO")
    private Long monto;

    @Column(name = "ID_TARIFA")
    private String idTarifa;

    // Constructor con todas las propiedades
    public Alquileres(Long id,Long idCliente, Long estado, Long estadoRetiro, Long estadoDevolucion, Timestamp fechaHoraRetiro, Timestamp fechaHoraDevolucion, Long monto, String idTarifa) {
        this.id = id;
        this.idCliente = idCliente;
        this.estado = estado;
        this.estadoRetiro = estadoRetiro;
        this.estadoDevolucion = estadoDevolucion;
        this.fechaHoraRetiro = fechaHoraRetiro;
        this.fechaHoraDevolucion = fechaHoraDevolucion;
        this.monto = monto;
        this.idTarifa = idTarifa;
    }
}
