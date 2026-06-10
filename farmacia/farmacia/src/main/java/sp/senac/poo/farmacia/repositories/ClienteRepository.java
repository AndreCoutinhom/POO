package sp.senac.poo.farmacia.repositories;

import sp.senac.poo.farmacia.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
