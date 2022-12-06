package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.persistence.ElementoDAO;
import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.services.ExcepcionServiciosLaboratorio;
import edu.eci.cvds.services.ServiciosElemento;
import edu.eci.cvds.services.ServiciosEquipo;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;

public class ServiciosElementoImpl implements ServiciosElemento {
    @Inject
    private ElementoDAO elementoDAO;

    @Inject
    private ServiciosEquipo serviciosEquipo;

    @Override
    public Elemento consultarElemento(int id) throws ExcepcionServiciosLaboratorio {
        try {
            return elementoDAO.load(id);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosLaboratorio("Error al cargar elementos " + ex);
        }
    }

    @Override
    public List<Elemento> consultarElementos() throws ExcepcionServiciosLaboratorio {
        try {
            return elementoDAO.loadAll();
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosLaboratorio("Error al cargar elementos " + ex);
        }
    }

    @Override
    public void registrarElemento(Elemento elemento) throws ExcepcionServiciosLaboratorio {
        try {
            elementoDAO.save(elemento);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosLaboratorio("Error al registrar el elemento " + elemento.getId() + ex);
        }
    }

    @Override
    public List<Elemento> consultarElementosConNovedades() throws ExcepcionServiciosLaboratorio {
        try {
            return elementoDAO.loadWithNovedades();
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosLaboratorio("Error al cargar elementos " + ex);
        }
    }

    @Override
    public List<Elemento> consultarElementosConNovedades(int idEquipo) throws ExcepcionServiciosLaboratorio {
        try {
            return elementoDAO.loadWithNovedades(idEquipo);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosLaboratorio("Error al cargar elementos " + ex);
        }
    }

    @Override
    public void actualizarEquipo(int idel, Integer ideq) throws ExcepcionServiciosLaboratorio {
        try {
            elementoDAO.updatePC(idel, ideq);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosLaboratorio("Error al actualizar el equipo del elemento " + idel + ex);
        }
    }

    @Override
    public List<Elemento> consultarTipoElementoDisponibles(String tipo) throws ExcepcionServiciosLaboratorio {
        try {
            return elementoDAO.loadAvailableElementsType(tipo);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosLaboratorio("Error al cargar elementos disponibles del tipo " + tipo + ex);
        }
    }

    @Override
    public List<Elemento> consultarElementosDisponibles() throws ExcepcionServiciosLaboratorio {
        try {
            return elementoDAO.loadAvailableElements();
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosLaboratorio("Error al cargar elementos disponibles" + ex);
        }
    }

    @Override
    public void darBajaElemento(int idel) throws ExcepcionServiciosLaboratorio {
        try {
            elementoDAO.disableElement(idel);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosLaboratorio("Error al dar de baja elemento " + idel + ex);
        }
    }

    @Override
    public Equipo getEquipoAsociado(Integer equipo_id) {
        try {
            return serviciosEquipo.consultarEquipo(equipo_id);
        } catch (ExcepcionServiciosLaboratorio e) {
            throw new RuntimeException(e);
        }
    }

}
