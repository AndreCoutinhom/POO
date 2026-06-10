package sp.senac.poo.farmacia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sp.senac.poo.farmacia.models.Produto;
import sp.senac.poo.farmacia.repositories.ProdutoRepository;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public Optional<Produto> buscar(Long id) {
        return repository.findById(id);
    }

    public Produto atualizar(Long id, Produto produto) {
        produto.setId(id);
        return repository.save(produto);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
