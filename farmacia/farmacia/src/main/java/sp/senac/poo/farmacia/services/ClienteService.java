package sp.senac.poo.farmacia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sp.senac.poo.farmacia.models.Cliente;
import sp.senac.poo.farmacia.repositories.ClienteRepository;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente salvar(Cliente cliente) {
        return repository.save(cliente);
    }

    public Optional<Cliente> buscar(Long id) {
        return repository.findById(id);
    }

    public Cliente atualizar(Long id, Cliente cliente) {
        cliente.setId(id);
        return repository.save(cliente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

}
