package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Elemento;

import java.util.List;

public interface ServiciosElemento {

    public Elemento consultarElemento(int id) throws  ExcepcionServiciosLaboratorio;
    public List<Elemento> consultarElementos() throws ExcepcionServiciosLaboratorio;

    /**
     * Registra un nuevo elemento
     * 
     * @param elemento elemento a registrar
     * @throws ExcepcionServiciosLaboratorio si el identificador del elemento ya
     *                                       existe
     */
    public void registrarElemento(Elemento elemento) throws ExcepcionServiciosLaboratorio;

    /**
     * Consulta los elementos que tienen novedades asociadas
     * @return lista de elementos
     * @throws ExcepcionServiciosLaboratorio
     */

    public List<Elemento> consultarElementosConNovedades() throws ExcepcionServiciosLaboratorio;
}
