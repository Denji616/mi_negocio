package com.alquimia.mi_negocio.controller;

import org.springframework.web.bind.annotation.*;
import com.alquimia.mi_negocio.model.Cliente;
import com.alquimia.mi_negocio.service.ClienteService;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.crearCliente(cliente);
        return ResponseEntity.ok(nuevoCliente);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Cliente>> buscarClientes(@RequestParam String query) {
        List<Cliente> clientes = clienteService.buscarClientes(query);
        return ResponseEntity.ok(clientes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente clienteActualizado = clienteService.actualizarCliente(id, cliente);
        return ResponseEntity.ok(clienteActualizado);
    }
    @DeleteMapping("/{id}")
public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
    clienteService.eliminarCliente(id);
    return ResponseEntity.noContent().build();
    }
}