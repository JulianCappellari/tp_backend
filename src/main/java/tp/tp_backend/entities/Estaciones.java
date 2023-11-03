package tp.tp_backend.entities;



import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

@Entity(name = "estaciones")
@Data
@NoArgsConstructor

public class Estaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "FECHA_HORA_CREACION")
    private Timestamp dateCreacion;

    @Column(name = "LATITUD")
    private Double latitud;

    @Column(name = "LONGITUD")
    private Double longitud;

    // Constructor con todas las propiedades
    public Estaciones(Long id, String nombre, Timestamp dateCreacion, Double latitud, Double longitud) {
        this.id = id;
        this.nombre = nombre;
        this.dateCreacion = dateCreacion;
        this.latitud = latitud;
        this.longitud = longitud;
    }
}
