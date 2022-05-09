package com.trabajopractico.sistema.entities;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("auditoria")
public class Auditoria extends Usuario{
    
}
/*Cada usuario puede tener un único perfil asignado, y los mismos deben ser definidos previos a la vinculación con el
usuario. Se solicitan al menos dos tipos de perfiles: administrador y auditoría. Cada vista o sección del sistema deberá
verificar el perfil del usuario logeado para habilitar / deshabilitar acciones según corresponda.
El sistema deberá permitir la alta, baja y modificación tanto de los usuarios como de los perfiles para aquellos usuarios
con perfil administrador. Y en el caso de los usuarios con perfil de auditoria los mismos podrán consultar tanto el listado
de los usuarios como el de administradores y descargar la información en un documento con formato PDF.
*/
