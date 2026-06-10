package sp.senac.poo.farmacia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import sp.senac.poo.farmacia.models.Estoque;
import sp.senac.poo.farmacia.services.EstoqueService;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService service;

    @PostMapping
    public Estoque salvar(@RequestBody Estoque estoque) {
        return service.salvar(estoque);
    }

    @GetMapping("/{id}")
    public Optional<Estoque> buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PutMapping("/{id}")
    public Estoque atualizar(@PathVariable Long id, @RequestBody Estoque estoque) {
        return service.atualizar(id, estoque);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.ok().build();
    }
}
