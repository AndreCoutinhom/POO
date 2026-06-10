package sp.senac.poo.farmacia.repositories;

import sp.senac.poo.farmacia.models.Lote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoteRepository extends JpaRepository<Lote, Long> {
}
