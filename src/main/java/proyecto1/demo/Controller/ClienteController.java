package proyecto1.demo.Controller;

import ch.qos.logback.core.net.server.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto1.demo.model.entity.Cliente;
import proyecto1.demo.service.ICliente;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    @Autowired
    private ICliente clienteService;

    @PostMapping("/cliente")
    public Cliente create(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @PutMapping("/cliente")
    public Cliente update(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @DeleteMapping("/cliente/{id}")
    public void delete(@PathVariable Integer id) {
        Cliente clienteDelete = clienteService.findById(id);
        clienteService.delete(clienteDelete);
    }

    @GetMapping("/cliente/{id}")
    public Cliente showById(@PathVariable Integer id) {
        return clienteService.findById(id);
    }
}
