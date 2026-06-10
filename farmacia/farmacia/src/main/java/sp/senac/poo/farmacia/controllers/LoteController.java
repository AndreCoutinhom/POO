package sp.senac.poo.farmacia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import sp.senac.poo.farmacia.models.Lote;
import sp.senac.poo.farmacia.services.LoteService;

@RestController
@RequestMapping("/lote")
public class LoteController {

    @Autowired
    private LoteService service;

    @PostMapping
    public Lote salvar(@RequestBody Lote lote) {
        return service.salvar(lote);
    }

    @GetMapping("/{id}")
    public Optional<Lote> buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PutMapping("/{id}")
    public Lote atualizar(@PathVariable Long id, @RequestBody Lote lote) {
        return service.atualizar(id, lote);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.ok().build();
    }
}
