package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Elemento;
import edu.eci.cvds.samples.entities.Equipo;
import edu.eci.cvds.samples.entities.Novedad;

import java.util.ArrayList;
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
    public Novedad consultarNovedad(int id) throws ExcepcionServiciosLaboratorio;
    public ArrayList<Novedad> consultarNovedades() throws ExcepcionServiciosLaboratorio;
    /**
     * Registra un nueva Novedad
     * @param novedad Novedad a registrar
     * @throws ExcepcionServiciosLaboratorio si el identificador de la novedad ya existe
     */
    public void registrarNovedad(Novedad novedad) throws ExcepcionServiciosLaboratorio;

}
