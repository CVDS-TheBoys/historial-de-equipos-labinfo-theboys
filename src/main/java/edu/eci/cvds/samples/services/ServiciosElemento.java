package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Elemento;

import java.util.List;

public interface ServiciosElemento {
    public List<Elemento> consultarElementos() throws ExcepcionServiciosLaboratorio;

    /**
     * Registra un nuevo elemento
     * @param elemento elemento a registrar
     * @throws ExcepcionServiciosLaboratorio si el identificador del elemento ya existe
     */
    public void registrarElemento(Elemento elemento) throws ExcepcionServiciosLaboratorio;

    /**
     * Actualiza el equipo al que pertenece el elemento
     * @param idel id del elemento
     * @param ideq id del equipo
     * @throws ExcepcionServiciosLaboratorio
     */
    public void actualizarEquipo(int idel, int ideq) throws ExcepcionServiciosLaboratorio;
}
