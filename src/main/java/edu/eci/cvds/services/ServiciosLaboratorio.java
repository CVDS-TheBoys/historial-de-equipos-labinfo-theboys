package edu.eci.cvds.services;

import edu.eci.cvds.entities.Laboratorio;

import java.util.ArrayList;

public interface ServiciosLaboratorio {
    /**
     * Consulta todos los laboratorios registrados
     *
     * @return lista de laboratorios registrados
     * @throws ExcepcionServiciosLaboratorio si no se pueden cargar los laboratorios
     */
    public ArrayList<Laboratorio> consultarLaboratorios() throws ExcepcionServiciosLaboratorio;

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
}
