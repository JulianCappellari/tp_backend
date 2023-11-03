package tp.tp_backend.entities.dto.trasnformations.AlquileresTransformation;

import org.springframework.stereotype.Service;
import tp.tp_backend.entities.Alquileres;
import tp.tp_backend.entities.dto.AlquileresDto;

import java.util.function.Function;

@Service
public class AlquileresDtoMapper implements Function<Alquileres, AlquileresDto> {

    @Override
    public AlquileresDto apply(Alquileres alquileres) {
        return new AlquileresDto(alquileres.getId(),alquileres.getIdCliente(), alquileres.getEstado(), alquileres.getEstadoRetiro(),
                alquileres.getEstadoDevolucion(), alquileres.getFechaHoraRetiro(), alquileres.getFechaHoraDevolucion(),
                alquileres.getMonto(), alquileres.getIdTarifa());
    }
}

