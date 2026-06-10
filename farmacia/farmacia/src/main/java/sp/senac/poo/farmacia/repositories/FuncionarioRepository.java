package sp.senac.poo.farmacia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sp.senac.poo.farmacia.models.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
