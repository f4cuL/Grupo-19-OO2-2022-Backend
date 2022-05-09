package com.trabajopractico.sistema.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("auditoria")
public class Auditoria extends Usuario{
    
}

