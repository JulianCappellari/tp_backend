package tp.tp_backend.entities.dto.trasnformations.EstacionesTransformation;

import org.springframework.stereotype.Service;
import tp.tp_backend.entities.Estaciones;
import tp.tp_backend.entities.dto.EstacionesDto;

import java.util.function.Function;

@Service
public class EstacionesDtoMapper implements Function<Estaciones, EstacionesDto> {

    @Override
    public EstacionesDto apply(Estaciones estaciones) {
        return new EstacionesDto(estaciones.getId(), estaciones.getNombre(), estaciones.getDateCreacion(), estaciones.getLatitud(), estaciones.getLongitud());
    }
}
