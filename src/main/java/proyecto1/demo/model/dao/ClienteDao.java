package proyecto1.demo.model.dao;

import org.springframework.data.repository.CrudRepository;
import proyecto1.demo.model.entity.Cliente;

public interface ClienteDao extends CrudRepository<Cliente, Integer> {
}
