package com.alquimia.mi_negocio.service;

import com.alquimia.mi_negocio.model.Cliente;
import com.alquimia.mi_negocio.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> buscarClientes(String query) {
        // Lógica de búsqueda, por ejemplo por nombres
        return clienteRepository.findByNamesContainingIgnoreCase(query);
    }

    public Cliente actualizarCliente(Long id, Cliente clienteActualizado) {
        return clienteRepository.findById(id).map(clienteExistente -> {
            clienteExistente.setNames(clienteActualizado.getNames());
            clienteExistente.setEmail(clienteActualizado.getEmail());
            clienteExistente.setCellphone(clienteActualizado.getCellphone());

            return clienteRepository.save(clienteExistente);
        }).orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));
    }

    public void eliminarCliente(Long id) {
    if (clienteRepository.existsById(id)) {
        clienteRepository.deleteById(id);
    } else {
        throw new RuntimeException("Cliente no encontrado con ID: " + id);
    }
}
}