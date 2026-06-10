package sp.senac.poo.farmacia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sp.senac.poo.farmacia.models.Funcionario;
import sp.senac.poo.farmacia.repositories.FuncionarioRepository;

import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public Funcionario salvar(Funcionario funcionario) {
        return repository.save(funcionario);
    }

    public Optional<Funcionario> buscar(Long id) {
        return repository.findById(id);
    }

    public Funcionario atualizar(Long id, Funcionario funcionario) {
        funcionario.setId(id);
        return repository.save(funcionario);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
