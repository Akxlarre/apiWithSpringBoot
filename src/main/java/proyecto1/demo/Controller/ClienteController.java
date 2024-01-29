package proyecto1.demo.Controller;

import ch.qos.logback.core.net.server.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import proyecto1.demo.model.Dto.ClienteDto;
import proyecto1.demo.model.entity.Cliente;
import proyecto1.demo.service.ICliente;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    @Autowired
    private ICliente clienteService;

    @PostMapping("/cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDto create(@RequestBody ClienteDto clienteDto) {
       Cliente clienteSave = clienteService.save(clienteDto);
        return ClienteDto.builder().idCliente(clienteSave.getIdCliente())
               .nombre(clienteSave.getNombre())
               .apellido(clienteSave.getApellido())
               .fechaRegistro(clienteSave.getFechaRegistro())
               .build();

    }

    @PutMapping("/cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDto update(@RequestBody ClienteDto clienteDto) {
        Cliente clienteUpdate = clienteService.save(clienteDto);
        return ClienteDto.builder().idCliente(clienteUpdate.getIdCliente())
                .nombre(clienteUpdate.getNombre())
                .apellido(clienteUpdate.getApellido())
                .fechaRegistro(clienteUpdate.getFechaRegistro())
                .build();
    }

    @DeleteMapping("/cliente/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        Cliente clienteDelete = clienteService.findById(id);
        clienteService.delete(clienteDelete);
    }

    @GetMapping("/cliente/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteDto showById(@PathVariable Integer id) {
        Cliente cliente = clienteService.findById(id);
        return ClienteDto.builder().idCliente(cliente.getIdCliente())
                .nombre(cliente.getNombre())
                .apellido(cliente.getApellido())
                .fechaRegistro(cliente.getFechaRegistro())
                .build();


    }
}
