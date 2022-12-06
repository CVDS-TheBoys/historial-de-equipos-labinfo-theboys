package edu.eci.cvds.services;

import edu.eci.cvds.entities.Usuario;

public interface ServiciosUsuario {
    public Usuario consultarUsuario(String email, String contra) throws ExcepcionServiciosLaboratorio;
}
