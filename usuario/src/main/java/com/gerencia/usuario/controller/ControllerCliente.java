package com.gerencia.usuario.controller;
import com.gerencia.usuario.entity.Cliente;
import com.gerencia.usuario.service.ServiceCliente;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ControllerCliente {
    private final ServiceCliente serviceCliente;
    
    @PostMapping("/cliente")
    public Cliente postCliente(@RequestBody Cliente cliete){
        return serviceCliente.postCliente(cliete);
    }

    @GetMapping("/clientes")
    public List<Cliente> getAllClientes(){
        return serviceCliente.getAllCustomer();
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        Cliente cliente = serviceCliente.getClienteById(id);
        if (cliente == null) 
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(cliente);
    }
    @PutMapping("/cliente/{id}")
    public ResponseEntity<Cliente> updateCliete(@PathVariable Long id, @RequestBody Cliente cliente){
        Cliente existingCliente = serviceCliente.getClienteById(id);
            if (existingCliente == null)
                return ResponseEntity.notFound().build();
            existingCliente.setNome(cliente.getNome());
            existingCliente.setEmail(cliente.getEmail());
            existingCliente.setTelefone(cliente.getTelefone());
            Cliente updatedCliente = serviceCliente.updateCliente(existingCliente);
            return ResponseEntity.ok(updatedCliente);
    }

    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable Long id){
        Cliente existingCliente = serviceCliente.getClienteById(id);
        if(existingCliente == null)
            return ResponseEntity.notFound().build();
        serviceCliente.deleteCliente(id);
        return ResponseEntity.ok().build();
    }

}
