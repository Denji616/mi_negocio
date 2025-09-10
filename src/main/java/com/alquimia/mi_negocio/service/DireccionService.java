package com.alquimia.mi_negocio.service;

import com.alquimia.mi_negocio.model.Direccion;
import com.alquimia.mi_negocio.repository.DireccionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DireccionService {

    private final DireccionRepository direccionRepository;

    public DireccionService(DireccionRepository direccionRepository) {
        this.direccionRepository = direccionRepository;
    }

    public Direccion guardarDireccion(Direccion direccion) {
        return direccionRepository.save(direccion);
    }
    
    // Este es el nuevo método que debes agregar
    public List<Direccion> findByClienteId(Long clienteId) {
        return direccionRepository.findByClienteId(clienteId);
    }
}