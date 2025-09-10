package com.alquimia.mi_negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alquimia.mi_negocio.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByIdentificationNumber(String identificationNumber);
    List<Cliente> findByIdentificationNumberContainingOrNamesContaining(String identificationNumber, String names);
    List<Cliente> findByNamesContainingIgnoreCase(String query);
}