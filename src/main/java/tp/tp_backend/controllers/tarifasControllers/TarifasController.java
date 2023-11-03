package tp.tp_backend.controllers.tarifasControllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tp.tp_backend.entities.dto.TarifasDto;
import tp.tp_backend.servicies.tarifas.TarifasService;

import org.springframework.http.ResponseEntity;


import java.util.List;

@RestController
@RequestMapping("api/tarifas")
public class TarifasController {
    private final TarifasService tarifasService;

    @Autowired
    public TarifasController(TarifasService tarifasService) {
        this.tarifasService = tarifasService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarifasDto> getById(@PathVariable("id") long id) {
        TarifasDto res = tarifasService.getById(id);
        return ResponseEntity.ok(res);
    }

    @GetMapping
    public ResponseEntity<List<TarifasDto>> getAll() {
        List<TarifasDto> values = tarifasService.getAll();
        return ResponseEntity.ok(values);
    }

    @PostMapping
    public ResponseEntity<TarifasDto> add(@RequestBody TarifasDto tarifasDto) {
        tarifasService.add(tarifasDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody TarifasDto entity,
                                       @PathVariable("id") Long id) {
        tarifasService.update(entity, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        tarifasService.delete(id);
        return ResponseEntity.ok().build();
    }
}

