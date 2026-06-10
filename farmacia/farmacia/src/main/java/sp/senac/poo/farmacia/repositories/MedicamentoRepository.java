package sp.senac.poo.farmacia.repositories;

import sp.senac.poo.farmacia.models.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
}
