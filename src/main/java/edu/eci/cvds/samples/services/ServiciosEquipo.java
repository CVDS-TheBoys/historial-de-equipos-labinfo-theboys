package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Equipo;

import java.util.List;

public interface ServiciosEquipo {
    /**
     * Consulta todos los equipos registrados
     * @return lista de equipos registrados
     * @throws ExcepcionServiciosLaboratorio si no puede cargar los equipos
     */
    public List<Equipo> consultarEquipos() throws ExcepcionServiciosLaboratorio;
    /**
     * Registra un nuevo equipo
     * @param equipo elemento a registrar
     * @throws ExcepcionServiciosLaboratorio si el identificador del equipo ya existe
     */
    public void registrarEquipo(Equipo equipo) throws ExcepcionServiciosLaboratorio;

    /**
     *  Consulta el reporte de los equipos activo
     */
    public List<Equipo> consultarReporte() throws  ExcepcionServiciosLaboratorio;
}
