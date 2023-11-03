package tp.tp_backend.controllers.alquileresControllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import tp.tp_backend.entities.dto.AlquileresDto;
import tp.tp_backend.servicies.alquileres.AlquileresService;


import java.util.List;

@RestController
@RequestMapping("api/alquileres")
public class AlquileresController {
    private final AlquileresService alquileresService;

    @Autowired
    public AlquileresController(AlquileresService alquileresService) {
        this.alquileresService = alquileresService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlquileresDto> getById(@PathVariable("id") long id) {
        AlquileresDto res = alquileresService.getById(id);
        return ResponseEntity.ok(res);
    }

    @GetMapping
    public ResponseEntity<List<AlquileresDto>> getAll() {
        List<AlquileresDto> values = alquileresService.getAll();
        return ResponseEntity.ok(values);
    }

    @PostMapping
    public ResponseEntity<AlquileresDto> add(@RequestBody AlquileresDto alquileresDto) {
        alquileresService.add(alquileresDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody AlquileresDto entity,
                                       @PathVariable("id") Long id) {
        alquileresService.update(entity, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        alquileresService.delete(id);
        return ResponseEntity.ok().build();
    }
}
