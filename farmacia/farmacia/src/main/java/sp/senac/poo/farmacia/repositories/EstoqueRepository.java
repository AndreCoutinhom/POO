package sp.senac.poo.farmacia.repositories;

import sp.senac.poo.farmacia.models.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
}
