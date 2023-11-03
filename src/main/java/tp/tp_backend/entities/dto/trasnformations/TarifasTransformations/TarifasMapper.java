package tp.tp_backend.entities.dto.trasnformations.TarifasTransformations;



import org.springframework.stereotype.Service;
import tp.tp_backend.entities.Tarifas;
import tp.tp_backend.entities.dto.TarifasDto;


import java.util.function.Function;

@Service
public class TarifasMapper implements Function<TarifasDto, Tarifas> {

    @Override
    public Tarifas apply(TarifasDto tarifasDto) {
        return new Tarifas(tarifasDto.getTipoTarifa(), tarifasDto.getDefinicion(), tarifasDto.getDiaSemana(),
                tarifasDto.getDiaMes(), tarifasDto.getMes(), tarifasDto.getAnio(), tarifasDto.getMontoFijoAlquiler(),
                tarifasDto.getMontoMinutoFraccion(), tarifasDto.getMontoKm(), tarifasDto.getMontoHora());
    }
}
