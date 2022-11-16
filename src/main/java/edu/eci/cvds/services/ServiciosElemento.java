package edu.eci.cvds.services;

import edu.eci.cvds.entities.Elemento;

import java.util.List;

public interface ServiciosElemento {
    /**
     * Consulta un elemento por id
     * @param id del elemento
     * @return elemento con el id del parametro
     * @throws ExcepcionServiciosLaboratorio
     */
    public Elemento consultarElemento(int id) throws  ExcepcionServiciosLaboratorio;

    /**
     * Consulta los elementos registrados
     * @return lista con los elementos registrados
     * @throws ExcepcionServiciosLaboratorio
     */
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

    /**
     * Consulta los elementos de un equipo que tienen novedades asociadas
     * @param idEquipo del equipo
     * @return lista de elementos
     * @throws ExcepcionServiciosLaboratorio
     */
    public List<Elemento> consultarElementosConNovedades(int idEquipo) throws ExcepcionServiciosLaboratorio;

    /**
     * Actualiza el equipo al que pertenece el elemento
     * @param idel id del elemento
     * @param ideq id del equipo
     * @throws ExcepcionServiciosLaboratorio
     */
    public void actualizarEquipo(int idel, Integer ideq) throws ExcepcionServiciosLaboratorio;

    /**
     * Consulta los elementos disponibles segun el tipo que se ingrese
     * @param tipo de elemento
     * @return lista de id's de los elementos disponibles segun el tipo
     * @throws ExcepcionServiciosLaboratorio
     */
    public List<Elemento> consultarTipoElementoDisponibles(String tipo) throws ExcepcionServiciosLaboratorio;

    /**
     * Consulta los elementos funcionales disponibles
     * @return lista de elementos disponibles
     * @throws ExcepcionServiciosLaboratorio si no es posible cargar los elementos
     */
    public List<Elemento> consultarElementosDisponibles() throws ExcepcionServiciosLaboratorio;

    /**
     * Da de baja un elemento haciendo que el atributo funcional sea falso
     * @param idel id del elemento
     * @throws ExcepcionServiciosLaboratorio si no es posible cargar los elementos
     */
    public void darBajaElemento(int idel) throws ExcepcionServiciosLaboratorio;
}
