package com.mikipmax.clienteservice.servicio;


import com.mikipmax.clienteservice.excepciones.NotFoundException;
import com.mikipmax.clienteservice.modelo.Cliente;
import com.mikipmax.clienteservice.repositorio.ClienteRepositorio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClienteServicio {


    private final ClienteRepositorio clienteRepositorio;

    public Flux<Cliente> listarClientes() {
        return Flux.defer(() -> Flux.fromIterable(this.clienteRepositorio.findAll()));
    }


    public Mono<Cliente> buscarPorId(Long id) {
        return Mono
                .defer(() -> Mono.just(this.clienteRepositorio.findById(id).orElseThrow(() -> new NotFoundException("Entidad no encontrada"))));

    }

    public Cliente crearOActualizar(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    public void eliminar(Long idCliente) {
        clienteRepositorio.deleteById(idCliente);
    }

    public Mono<Cliente> buscarPorIdentificacion(String identificacion) {
        return Mono
                .defer(() -> Mono.just(clienteRepositorio.findClienteByIdentificacion(identificacion)));
    }

}
