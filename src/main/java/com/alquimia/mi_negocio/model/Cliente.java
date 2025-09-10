package com.alquimia.mi_negocio.model;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data; 

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String identificationType;
    private String identificationNumber;
    private String names;
    private String email;
    private String cellphone;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Direccion> direcciones;
}