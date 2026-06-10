package sp.senac.poo.farmacia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sp.senac.poo.farmacia.models.Compra;
import sp.senac.poo.farmacia.repositories.CompraRepository;

import java.util.Optional;

@Service
public class CompraService {

    @Autowired
    private CompraRepository repository;

    public Compra salvar(Compra compra) {
        return repository.save(compra);
    }

    public Optional<Compra> buscar(Long id) {
        return repository.findById(id);
    }

    public Compra atualizar(Long id, Compra compra) {
        compra.setId(id);
        return repository.save(compra);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

}
