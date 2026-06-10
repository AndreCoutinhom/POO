package sp.senac.poo.farmacia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import sp.senac.poo.farmacia.models.Compra;
import sp.senac.poo.farmacia.services.CompraService;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private CompraService service;

    @PostMapping
    public Compra salvar(@RequestBody Compra compra) {
        return service.salvar(compra);
    }

    @GetMapping("/{id}")
    public Optional<Compra> buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PutMapping("/{id}")
    public Compra atualizar(@PathVariable Long id, @RequestBody Compra compra) {
        return service.atualizar(id, compra);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.ok().build();
    }
}
