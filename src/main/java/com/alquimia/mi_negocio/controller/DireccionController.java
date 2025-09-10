package com.alquimia.mi_negocio.controller;

import com.alquimia.mi_negocio.model.Direccion;
import com.alquimia.mi_negocio.service.DireccionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/direcciones")
public class DireccionController {

    private final DireccionService direccionService;

    public DireccionController(DireccionService direccionService) {
        this.direccionService = direccionService;
    }

    @PostMapping("/registrar")
    public ResponseEntity<Direccion> registrarDireccion(@RequestBody Direccion direccion) {
        Direccion nuevaDireccion = direccionService.guardarDireccion(direccion);
        return ResponseEntity.ok(nuevaDireccion);
    }
    
    // Este es el nuevo método que debes agregar
    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Direccion>> listarDireccionesPorCliente(@PathVariable Long clienteId) {
        List<Direccion> direcciones = direccionService.findByClienteId(clienteId);
        return ResponseEntity.ok(direcciones);
    }
}