package tp.tp_backend.entities.dto.trasnformations.TarifasTransformations;

import org.springframework.stereotype.Service;
import tp.tp_backend.entities.Tarifas;
import tp.tp_backend.entities.dto.TarifasDto;

import java.util.function.Function;

@Service
public class TarifasDtoMapper implements Function<Tarifas, TarifasDto> {

    @Override
    public TarifasDto apply(Tarifas tarifas) {
        return new TarifasDto(tarifas.getTipoTarifa(), tarifas.getDefinicion(), tarifas.getDiaSemana(),
                tarifas.getDiaMes(), tarifas.getMes(), tarifas.getAnio(), tarifas.getMontoFijoAlquiler(),
                tarifas.getMontoMinutoFraccion(), tarifas.getMontoKm(), tarifas.getMontoHora());
    }
}
