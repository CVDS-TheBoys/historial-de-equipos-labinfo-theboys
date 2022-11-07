package edu.eci.cvds.services;

import java.util.ArrayList;
import java.util.List;

import edu.eci.cvds.entities.Novedad;

public interface ServiciosNovedad {

    /**
     * Consulta todas las novedades registradas
     * 
     * @return lista de novedades registradas
     * @throws ExcepcionServiciosLaboratorio si no se pueden cargar las novedades
     */
    public ArrayList<Novedad> consultarNovedades() throws ExcepcionServiciosLaboratorio;

    /**
     * Registra una nueva novedad
     * 
     * @param novedad novedad a registrar
     * @throws ExcepcionServiciosLaboratorio si el identificador de la novedad ya
     *                                       existe
     */
    public void registrarNovedad(Novedad novedad) throws ExcepcionServiciosLaboratorio;

    /**
     * Consulta novedad en especifico
     * 
     * @return novedad
     * @throws ExcepcionServiciosLaboratorio si no se pueden cargar la novedad
     */
    public Novedad consultarNovedad(int id) throws ExcepcionServiciosLaboratorio;

    /**
     * Consulta las novedades de un Elemento específico
     * 
     * @param id ID del Elemento en cuestión
     * @return lista de novedades del Elemento
     * @throws ExcepcionServiciosLaboratorio si no se pueden cargar las novedades
     */
    public List<Novedad> consultarNovedadesElemento(int id) throws ExcepcionServiciosLaboratorio;

    /**
     * Consulta las novedades de un Equipo específico
     * 
     * @param id ID del Equipo en cuestión
     * @return lista de novedades del Equipo
     * @throws ExcepcionServiciosLaboratorio si no se pueden cargar las novedades
     */
    public List<Novedad> consultarNovedadesEquipo(int id) throws ExcepcionServiciosLaboratorio;
}
