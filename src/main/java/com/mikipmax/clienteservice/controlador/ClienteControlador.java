package com.mikipmax.clienteservice.controlador;


import com.mikipmax.clienteservice.modelo.Cliente;
import com.mikipmax.clienteservice.servicio.ClienteServicio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/clientes")
public class ClienteControlador {


    private final ClienteServicio clienteServicio;

    public ClienteControlador(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }

    @GetMapping
    public Flux<Cliente> obtenerClientes() {
        return clienteServicio.listarClientes();
    }

    @GetMapping("/{id}")
    public Mono<Cliente> obtenerCliente(@PathVariable Long id) {
        return clienteServicio.buscarPorId(id);
    }

    @PostMapping
    public Cliente crear(@RequestBody Cliente e) {
        return clienteServicio.crearOActualizar(e);
    }

    @PutMapping
    public Cliente actualizar(@RequestBody Cliente e) {
        return clienteServicio.crearOActualizar(e);
    }

    @DeleteMapping("/{id}")
    public void actualizar(@PathVariable("id") Long id) {
        clienteServicio.eliminar(id);
    }

    @GetMapping("/identificacion/{identificacion}")
    public Mono<Cliente> obtenerClientePorIdentificacion(@PathVariable String identificacion) {
        return clienteServicio.buscarPorIdentificacion(identificacion);
    }
}
