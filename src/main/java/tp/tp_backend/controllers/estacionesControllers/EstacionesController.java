package tp.tp_backend.controllers.estacionesControllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tp.tp_backend.entities.dto.EstacionesDto;
import tp.tp_backend.servicies.estaciones.EstacionesService;

import org.springframework.http.ResponseEntity;


import java.util.List;

@RestController
@RequestMapping("api/estaciones")
public class EstacionesController {
    private final EstacionesService estacionesService;

    @Autowired
    public EstacionesController(EstacionesService estacionesService) {
        this.estacionesService = estacionesService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstacionesDto> getById(@PathVariable("id") long id) {
        EstacionesDto res = estacionesService.getById(id);
        return ResponseEntity.ok(res);
    }

    @GetMapping
    public ResponseEntity<List<EstacionesDto>> getAll() {
        List<EstacionesDto> values = estacionesService.getAll();
        return ResponseEntity.ok(values);
    }

    @PostMapping
    public ResponseEntity<EstacionesDto> add(@RequestBody EstacionesDto estacionesDto) {
        estacionesService.add(estacionesDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody EstacionesDto entity,
                                       @PathVariable("id") Long id) {
        estacionesService.update(entity, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        estacionesService.delete(id);
        return ResponseEntity.ok().build();
    }
}
