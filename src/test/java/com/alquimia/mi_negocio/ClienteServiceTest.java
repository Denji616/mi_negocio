package com.alquimia.mi_negocio;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.alquimia.mi_negocio.model.Cliente;
import com.alquimia.mi_negocio.repository.ClienteRepository;
import com.alquimia.mi_negocio.service.ClienteService;

import static org.mockito.Mockito.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @Test
    void testCrearCliente_ClienteExistente_LanzaExcepcion() {
        // Dado un cliente existente con el mismo número de identificación
        when(clienteRepository.findByIdentificationNumber("12345")).thenReturn(Optional.of(new Cliente()));

        // Cuando intentas crear un nuevo cliente con ese mismo ID
        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setIdentificationNumber("12345");

        // Entonces se espera una excepción
        assertThrows(RuntimeException.class, () -> clienteService.crearCliente(nuevoCliente));
    }
}