package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Elemento;
import edu.eci.cvds.samples.entities.Equipo;

import java.util.List;

public interface ServiciosLaboratorio {

    public List<Elemento> consultarElementos() throws ExcepcionServiciosLaboratorio;

    /**
     * Registra un nuevo elemento
     * @param elemento elemento a registrar
     * @throws ExcepcionServiciosLaboratorio si el identificador del elemento ya existe
     */
    public void registrarElemento(Elemento elemento) throws ExcepcionServiciosLaboratorio;
    public List<Equipo> consultarEquipos() throws ExcepcionServiciosLaboratorio;
    /**
     * Registra un nuevo equipo
     * @param equipo elemento a registrar
     * @throws ExcepcionServiciosLaboratorio si el identificador del equipo ya existe
     */
    public void registrarEquipo(Equipo equipo) throws ExcepcionServiciosLaboratorio;

}
