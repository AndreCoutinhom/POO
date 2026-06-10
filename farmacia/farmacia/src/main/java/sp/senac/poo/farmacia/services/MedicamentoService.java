package sp.senac.poo.farmacia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sp.senac.poo.farmacia.models.Medicamento;
import sp.senac.poo.farmacia.repositories.MedicamentoRepository;

import java.util.Optional;

@Service
public class MedicamentoService {

    @Autowired
    private MedicamentoRepository repository;

    public Medicamento salvar(Medicamento medicamento) {
        return repository.save(medicamento);
    }

    public Optional<Medicamento> buscar(Long id) {
        return repository.findById(id);
    }

    public Medicamento atualizar(Long id, Medicamento medicamento) {
        medicamento.setId(id);
        return repository.save(medicamento);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
