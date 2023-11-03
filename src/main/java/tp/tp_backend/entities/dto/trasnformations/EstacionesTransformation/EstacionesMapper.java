package tp.tp_backend.entities.dto.trasnformations.EstacionesTransformation;



import org.springframework.stereotype.Service;
import tp.tp_backend.entities.Estaciones;
import tp.tp_backend.entities.dto.EstacionesDto;


import java.util.function.Function;

@Service
public class EstacionesMapper implements Function<EstacionesDto, Estaciones> {

    @Override
    public Estaciones apply(EstacionesDto estacionesDto) {
        return new Estaciones(estacionesDto.getId(), estacionesDto.getNombre(), estacionesDto.getDateCreacion(), estacionesDto.getLatitud(), estacionesDto.getLongitud());
    }
}
