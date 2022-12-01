package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.persistence.EquipoDAO;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.services.ExcepcionServiciosLaboratorio;
import edu.eci.cvds.services.ServiciosEquipo;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;

public class ServiciosEquipoImpl implements ServiciosEquipo {
    @Inject
    private EquipoDAO equipoDAO;

    @Override
    public Equipo consultarEquipo(int id) throws ExcepcionServiciosLaboratorio {
        try {
            return equipoDAO.load(id);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosLaboratorio("Error al cargar los equipos " + ex);
        }
    }

    @Override
    public List<Equipo> consultarEquipos() throws ExcepcionServiciosLaboratorio {
        try {
            return equipoDAO.loadAll();
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosLaboratorio("Error al cargar los equipos " + ex);
        }
    }

    @Override
    public void registrarEquipo(Equipo equipo) throws ExcepcionServiciosLaboratorio {
        try {
            equipoDAO.save(equipo);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosLaboratorio("Error al registrar el equipo " + equipo.getId() + ex);
        }
    }

    @Override
    public List<Equipo> consultarEquiposConNovedades() throws ExcepcionServiciosLaboratorio {
        try {
            return equipoDAO.loadWithNovedades();
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosLaboratorio("Error al cargar novedades de los equipos " + ex);
        }
    }

    @Override
    public List<Equipo> consultarReporte() throws ExcepcionServiciosLaboratorio {
        return equipoDAO.consultarReporte();
    }

    @Override
    public Elemento consultarElementoTipo(int equipoId, String tipo) throws ExcepcionServiciosLaboratorio {
        try {
            Equipo equipo = equipoDAO.load(equipoId);
            for (Elemento ele : equipo.getElementos()) {
                if (ele.getTipo().equals(tipo)) {
                    return ele;
                }
            }
            return null;
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosLaboratorio("Error al cargar novedades de los equipos " + ex);
        }
    }

    @Override
    public List<Equipo> consultarEquiposDisponibles() throws ExcepcionServiciosLaboratorio {
        try {
            return equipoDAO.loadAvailableDevice();
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosLaboratorio("Error al cargar equipos disponibles" + ex);
        }
    }

    @Override
    public void darBajaEquipo(int id) throws ExcepcionServiciosLaboratorio {
        try {
            equipoDAO.disableDevice(id);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosLaboratorio("Error al dar de baja equipo: " +
                    id + ex);
        }
    }

    @Override
    public List<Equipo> consultarEquiposLaboratorio(int id) throws ExcepcionServiciosLaboratorio {
        try {
            return equipoDAO.loadLabDevice(id);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosLaboratorio("Error al consultar equipos asociados a laboratorio: " +
                    id + ex);
        }
    }
}
