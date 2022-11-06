package edu.eci.cvds.samples.services;

import edu.eci.cvds.sampleprj.dao.EquipoDAO;
import edu.eci.cvds.samples.entities.Equipo;

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
}
