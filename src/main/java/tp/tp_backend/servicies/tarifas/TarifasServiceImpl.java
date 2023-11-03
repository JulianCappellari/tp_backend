package tp.tp_backend.servicies.tarifas;

import org.springframework.stereotype.Service;
import tp.tp_backend.entities.Tarifas;
import tp.tp_backend.entities.dto.TarifasDto;
import tp.tp_backend.entities.dto.trasnformations.TarifasTransformations.TarifasDtoMapper;
import tp.tp_backend.entities.dto.trasnformations.TarifasTransformations.TarifasMapper;
import tp.tp_backend.repositories.TarifasRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TarifasServiceImpl implements TarifasService {
    private final TarifasRepository tarifasRepository;
    private final TarifasDtoMapper tarifasDtoMapper;
    private final TarifasMapper tarifasMapper;

    public TarifasServiceImpl(TarifasRepository tarifasRepository,
                              TarifasDtoMapper tarifasDtoMapper,
                              TarifasMapper tarifasMapper) {
        this.tarifasRepository = tarifasRepository;
        this.tarifasDtoMapper = tarifasDtoMapper;
        this.tarifasMapper = tarifasMapper;
    }

    @Override
    public void add(TarifasDto entity) {
        Tarifas tarifas = Optional.of(entity).map(tarifasMapper).get();
        tarifasRepository.save(tarifas);
    }

    @Override
    public TarifasDto getById(Long id) {
        Optional<Tarifas> tarifas = tarifasRepository.findById(id);
        return tarifas
                .map(tarifasDtoMapper)
                .orElseThrow();
    }

    @Override
    public List<TarifasDto> getAll() {
        List<Tarifas> values = tarifasRepository.findAll();
        return values
                .stream()
                .map(tarifasDtoMapper)
                .toList();
    }

    @Override
    public TarifasDto delete(Long id) {
        Optional<Tarifas> optionalTarifas = tarifasRepository.findById(id);
        optionalTarifas.ifPresent(tarifasRepository::delete);
        return optionalTarifas
                .map(tarifasDtoMapper)
                .orElseThrow();
    }

    @Override
    public void update(TarifasDto entity, Long id) {
        Optional<Tarifas> tarifas = tarifasRepository.findById(id);
        Tarifas tarifaExistente = tarifas.orElseThrow(() -> new RuntimeException("Tarifa no encontrada con ID: " + id));

        tarifaExistente.setTipoTarifa(entity.getTipoTarifa());
        tarifaExistente.setDefinicion(entity.getDefinicion());
        tarifaExistente.setDiaSemana(entity.getDiaSemana());
        tarifaExistente.setDiaMes(entity.getDiaMes());
        tarifaExistente.setMes(entity.getMes());
        tarifaExistente.setAnio(entity.getAnio());
        tarifaExistente.setMontoFijoAlquiler(entity.getMontoFijoAlquiler());
        tarifaExistente.setMontoMinutoFraccion(entity.getMontoMinutoFraccion());
        tarifaExistente.setMontoKm(entity.getMontoKm());
        tarifaExistente.setMontoHora(entity.getMontoHora());

        tarifasRepository.save(tarifaExistente);
    }
}

