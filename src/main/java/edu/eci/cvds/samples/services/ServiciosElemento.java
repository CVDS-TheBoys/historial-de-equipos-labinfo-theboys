package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Elemento;

import java.util.ArrayList;
import java.util.List;

public interface ServiciosElemento {
    public List<Elemento> consultarElementos() throws ExcepcionServiciosLaboratorio;

    /**
     * Registra un nuevo elemento
     * @param elemento elemento a registrar
     * @throws ExcepcionServiciosLaboratorio si el identificador del elemento ya existe
     */
    public void registrarElemento(Elemento elemento) throws ExcepcionServiciosLaboratorio;
}
