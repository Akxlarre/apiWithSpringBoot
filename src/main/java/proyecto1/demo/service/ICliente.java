package proyecto1.demo.service;

import proyecto1.demo.model.entity.Cliente;

public interface ICliente {

    Cliente save(Cliente cliente);
    Cliente findById(Integer id);
    void delete(Cliente cliente);


}
