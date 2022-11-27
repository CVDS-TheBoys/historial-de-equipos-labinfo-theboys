package edu.eci.cvds.services;

import edu.eci.cvds.entities.Laboratorio;

import java.util.List;

public interface ServiciosLaboratorio {
    /**
     * Consulta todos los laboratorios registrados
     *
     * @return lista de laboratorios registrados
     * @throws ExcepcionServiciosLaboratorio si no se pueden cargar los laboratorios
     */
    public List<Laboratorio> consultarLaboratorios() throws ExcepcionServiciosLaboratorio;

    /**
     * Registra un laboratorio
     *
     * @param laboratorio laboratorio a registrar
     * @throws ExcepcionServiciosLaboratorio si el identificador del laboratorio ya
     *                                       existe
     */
    public void registrarLaboratorio(Laboratorio laboratorio) throws ExcepcionServiciosLaboratorio;

    /**
     * Consulta laboratorio en especifico
     *
     * @return laboratorio
     * @throws ExcepcionServiciosLaboratorio si no se pueden cargar el laboratorio
     */
    public Laboratorio consultarLaboratorio(int id) throws ExcepcionServiciosLaboratorio;

    /**
     * Cerrar laboratorio dejando el estado en falso
     * 
     * @param id id del laboratiorio
     * @throws ExcepcionServiciosLaboratorio
     */
    public void cerrarLaboratorio(int id) throws ExcepcionServiciosLaboratorio;
}
