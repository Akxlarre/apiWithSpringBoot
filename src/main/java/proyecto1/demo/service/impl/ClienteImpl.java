package proyecto1.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proyecto1.demo.model.Dto.ClienteDto;
import proyecto1.demo.model.dao.ClienteDao;
import proyecto1.demo.model.entity.Cliente;
import proyecto1.demo.service.ICliente;

@Service
public class ClienteImpl implements ICliente {

    @Autowired
    private ClienteDao clienteDao;

    @Transactional
    @Override
    public Cliente save(ClienteDto clienteDto) {
        Cliente cliente = Cliente.builder().idCliente(clienteDto.getIdCliente())
                .nombre(clienteDto.getNombre())
                .apellido(clienteDto.getApellido())
                .fechaRegistro(clienteDto.getFechaRegistro())
                .build();
        return clienteDao.save(cliente);
    }

    @Transactional(readOnly = true)
    @Override
    public Cliente findById(Integer id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }
}

