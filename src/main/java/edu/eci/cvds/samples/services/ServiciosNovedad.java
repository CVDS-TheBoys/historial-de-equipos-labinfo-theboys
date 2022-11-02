package edu.eci.cvds.samples.services;

import java.util.ArrayList;

import edu.eci.cvds.samples.entities.Novedad;

public interface ServiciosNovedad {
    public ArrayList<Novedad> consultarNovedades() throws ExcepcionServiciosLaboratorio;

    /**
     * Registra una nueva novedad
     * 
     * @param novedad novedad a registrar
     * @throws ExcepcionServiciosLaboratorio si el identificador de la novedad ya
     *                                       existe
     */
    public void registrarNovedad(Novedad novedad) throws ExcepcionServiciosLaboratorio;
}
