package edu.eci.cvds.services;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Equipo;

import java.util.List;

public interface ServiciosEquipo {

    /**
     * Consulta un equipo por ID
     * @param id id del equipo
     * @return el equipo
     * @throws ExcepcionServiciosLaboratorio si no se puede cargar el equipo
     */
    public Equipo consultarEquipo(int id) throws ExcepcionServiciosLaboratorio;
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
     * Consultar equipos con novedades asociadas
     * @return lista de equipos con novedades
     * @throws ExcepcionServiciosLaboratorio si no se pueden cargar los equipos
     */
    public List<Equipo> consultarEquiposConNovedades() throws ExcepcionServiciosLaboratorio;

    /**
     *  Consulta el reporte de los equipos activo
     */
    public List<Equipo> consultarReporte() throws  ExcepcionServiciosLaboratorio;

    /**
     * Consulta el elemento, del tipo especificado, de un equipo
     * @param equipoId id del quipo
     * @param tipo tipo del elemento a buscar
     * @return elemento del tipo especificado
     * @throws ExcepcionServiciosLaboratorio si no se pueden el elemento
     */
    public Elemento consultarElementoTipo(int equipoId, String tipo) throws ExcepcionServiciosLaboratorio;

}
