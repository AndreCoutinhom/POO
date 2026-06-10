package sp.senac.poo.farmacia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import sp.senac.poo.farmacia.models.Medicamento;
import sp.senac.poo.farmacia.services.MedicamentoService;

@RestController
@RequestMapping("/medicamento")
public class MedicamentoController {

    @Autowired
    private MedicamentoService service;

    @PostMapping
    public Medicamento salvar(@RequestBody Medicamento medicamento) {
        return service.salvar(medicamento);
    }

    @GetMapping("/{id}")
    public Optional<Medicamento> buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PutMapping("/{id}")
    public Medicamento atualizar(@PathVariable Long id, @RequestBody Medicamento medicamento) {
        return service.atualizar(id, medicamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.ok().build();
    }
}
