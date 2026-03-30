package com.gerencia.usuario.service;

import java.util.List;
import com.gerencia.usuario.entity.Cliente;
import com.gerencia.usuario.repository.RepositoryCliente;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceCliente {
    private final RepositoryCliente repositoryCliente;

    public Cliente postCliente(Cliente cliente){
        return repositoryCliente.save(cliente);
    }

    public List<Cliente> getAllCustomer(){
        return repositoryCliente.findAll();
    }

    public Cliente getClienteById(Long id){
        return repositoryCliente.findById(id).orElse(null);
    }

    public Cliente updateCliente(Cliente cliente){
        return repositoryCliente.save(cliente);
    }

    public void deleteCliente(long id){
        repositoryCliente.deleteById(id);
    }
}
