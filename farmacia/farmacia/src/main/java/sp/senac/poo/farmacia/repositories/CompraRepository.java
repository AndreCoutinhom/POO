package sp.senac.poo.farmacia.repositories;

import sp.senac.poo.farmacia.models.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra, Long> {
}
