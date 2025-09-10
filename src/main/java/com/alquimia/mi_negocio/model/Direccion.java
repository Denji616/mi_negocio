package com.alquimia.mi_negocio.model;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore; // Importa la clase JsonIgnore

@Entity
@Data
public class Direccion {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String province;
private String city;
private String address;

@ManyToOne
@JoinColumn(name = "cliente_id")
@JsonIgnore // ¡Agrega esta línea para evitar el loop!
private Cliente cliente;

private boolean isMainAddress;
}