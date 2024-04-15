package com.mikipmax.clienteservice.repositorio;

import com.mikipmax.clienteservice.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends CrudRepository<Cliente, Long> {

    Cliente findClienteByIdentificacion(String identificaicon);
}
