package tp.tp_backend.entities.dto.trasnformations.AlquileresTransformation;



import org.springframework.stereotype.Service;
import tp.tp_backend.entities.Alquileres;
import tp.tp_backend.entities.dto.AlquileresDto;


import java.util.function.Function;

@Service
public class AlquileresMapper implements Function<AlquileresDto, Alquileres> {

    @Override
    public Alquileres apply(AlquileresDto alquileresDto) {
        return new Alquileres(alquileresDto.getId(),alquileresDto.getIdCliente(), alquileresDto.getEstado(), alquileresDto.getEstadoRetiro(),
                alquileresDto.getEstadoDevolucion(), alquileresDto.getFechaHoraRetiro(), alquileresDto.getFechaHoraDevolucion(),
                alquileresDto.getMonto(), alquileresDto.getIdTarifa());
    }
}
