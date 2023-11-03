package tp.tp_backend.servicies.estaciones;

import org.springframework.stereotype.Service;
import tp.tp_backend.entities.Estaciones;
import tp.tp_backend.entities.dto.EstacionesDto;
import tp.tp_backend.entities.dto.trasnformations.EstacionesTransformation.EstacionesDtoMapper;
import tp.tp_backend.entities.dto.trasnformations.EstacionesTransformation.EstacionesMapper;
import tp.tp_backend.repositories.EstacionesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EstacionesServiceImpl implements EstacionesService {
    private final EstacionesRepository estacionesRepository;
    private final EstacionesDtoMapper estacionesDtoMapper;
    private final EstacionesMapper estacionesMapper;

    public EstacionesServiceImpl(EstacionesRepository estacionesRepository,
                                 EstacionesDtoMapper estacionesDtoMapper,
                                 EstacionesMapper estacionesMapper) {
        this.estacionesRepository = estacionesRepository;
        this.estacionesDtoMapper = estacionesDtoMapper;
        this.estacionesMapper = estacionesMapper;
    }

    @Override
    public void add(EstacionesDto entity) {
        Estaciones estaciones = Optional.of(entity).map(estacionesMapper).get();
        estacionesRepository.save(estaciones);
    }

    @Override
    public EstacionesDto getById(Long id) {
        Optional<Estaciones> estaciones = estacionesRepository.findById(id);
        return estaciones
                .map(estacionesDtoMapper)
                .orElseThrow();
    }

    @Override
    public List<EstacionesDto> getAll() {
        List<Estaciones> values = estacionesRepository.findAll();
        return values
                .stream()
                .map(estacionesDtoMapper)
                .toList();
    }

    @Override
    public EstacionesDto delete(Long id) {
        Optional<Estaciones> optionalEstaciones = estacionesRepository.findById(id);
        optionalEstaciones.ifPresent(estacionesRepository::delete);
        return optionalEstaciones
                .map(estacionesDtoMapper)
                .orElseThrow();
    }

    @Override
    public void update(EstacionesDto entity, Long id) {
        Optional<Estaciones> estaciones = estacionesRepository.findById(id);
        Estaciones estacionExistente = estaciones.orElseThrow(() -> new RuntimeException("Estación no encontrada con ID: " + id));

        estacionExistente.setNombre(entity.getNombre());
        estacionExistente.setDateCreacion(entity.getDateCreacion());
        estacionExistente.setLatitud(entity.getLatitud());
        estacionExistente.setLongitud(entity.getLongitud());

        estacionesRepository.save(estacionExistente);
    }

}

