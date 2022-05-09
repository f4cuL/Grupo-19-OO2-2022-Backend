package com.trabajopractico.sistema.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("admin")
public class Administrador extends Usuario{
    
}
