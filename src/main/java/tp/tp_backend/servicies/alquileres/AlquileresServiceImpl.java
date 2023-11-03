package tp.tp_backend.servicies.alquileres;

import org.springframework.stereotype.Service;
import tp.tp_backend.entities.Alquileres;
import tp.tp_backend.entities.dto.AlquileresDto;
import tp.tp_backend.entities.dto.trasnformations.AlquileresTransformation.AlquileresDtoMapper;
import tp.tp_backend.entities.dto.trasnformations.AlquileresTransformation.AlquileresMapper;
import tp.tp_backend.repositories.AlquileresRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AlquileresServiceImpl implements AlquileresService {
    private final AlquileresRepository alquileresRepository;
    private final AlquileresDtoMapper alquileresDtoMapper;
    private final AlquileresMapper alquileresMapper;

    public AlquileresServiceImpl(AlquileresRepository alquileresRepository,
                                 AlquileresDtoMapper alquileresDtoMapper,
                                 AlquileresMapper alquileresMapper) {
        this.alquileresRepository = alquileresRepository;
        this.alquileresDtoMapper = alquileresDtoMapper;
        this.alquileresMapper = alquileresMapper;
    }

    @Override
    public void add(AlquileresDto entity) {
        Alquileres alquileres = Optional.of(entity).map(alquileresMapper).get();
        alquileresRepository.save(alquileres);
    }

    @Override
    public AlquileresDto getById(Long id) {
        Optional<Alquileres> alquileres = alquileresRepository.findById(id);
        return alquileres
                .map(alquileresDtoMapper)
                .orElseThrow();
    }

    @Override
    public List<AlquileresDto> getAll() {
        List<Alquileres> values = alquileresRepository.findAll();
        return values
                .stream()
                .map(alquileresDtoMapper)
                .toList();
    }

    @Override
    public AlquileresDto delete(Long id) {
        Optional<Alquileres> optionalAlquileres = alquileresRepository.findById(id);
        optionalAlquileres.ifPresent(alquileresRepository::delete);
        return optionalAlquileres
                .map(alquileresDtoMapper)
                .orElseThrow();
    }

    @Override
    public void update(AlquileresDto entity, Long id) {
        Optional<Alquileres> alquileres = alquileresRepository.findById(id);
        Alquileres alquilerExistente = alquileres.get();
        alquilerExistente.setId(entity.getId());
        alquilerExistente.setIdCliente(entity.getIdCliente());
        alquilerExistente.setEstado(entity.getEstado());
        alquilerExistente.setEstadoRetiro(entity.getEstadoRetiro());
        alquilerExistente.setEstadoDevolucion(entity.getEstadoDevolucion());
        alquilerExistente.setFechaHoraRetiro(entity.getFechaHoraRetiro());
        alquilerExistente.setFechaHoraDevolucion(entity.getFechaHoraDevolucion());
        alquilerExistente.setMonto(entity.getMonto());
        alquilerExistente.setIdTarifa(entity.getIdTarifa());
        alquileresRepository.save(alquilerExistente);
    }
}

