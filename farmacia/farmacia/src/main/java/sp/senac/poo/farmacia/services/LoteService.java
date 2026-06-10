package sp.senac.poo.farmacia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sp.senac.poo.farmacia.models.Lote;
import sp.senac.poo.farmacia.repositories.LoteRepository;

import java.util.Optional;

@Service
public class LoteService {

    @Autowired
    private LoteRepository repository;

    public Lote salvar(Lote lote) {
        return repository.save(lote);
    }

    public Optional<Lote> buscar(Long id) {
        return repository.findById(id);
    }

    public Lote atualizar(Long id, Lote lote) {
        lote.setId(id);
        return repository.save(lote);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
