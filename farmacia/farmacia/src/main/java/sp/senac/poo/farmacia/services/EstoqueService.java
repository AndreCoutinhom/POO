package sp.senac.poo.farmacia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sp.senac.poo.farmacia.models.Estoque;
import sp.senac.poo.farmacia.repositories.EstoqueRepository;

import java.util.Optional;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository repository;

    public Estoque salvar(Estoque estoque) {
        return repository.save(estoque);
    }

    public Optional<Estoque> buscar(Long id) {
        return repository.findById(id);
    }

    public Estoque atualizar(Long id, Estoque estoque) {
        estoque.setId(id);
        return repository.save(estoque);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
