package sp.senac.poo.farmacia.repositories;

import sp.senac.poo.farmacia.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
