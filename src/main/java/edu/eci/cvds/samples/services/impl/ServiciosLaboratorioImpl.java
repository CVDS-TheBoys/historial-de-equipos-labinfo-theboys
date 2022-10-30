package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.ElementoDAO;
import edu.eci.cvds.sampleprj.dao.EquipoDAO;
import edu.eci.cvds.samples.entities.Elemento;
import edu.eci.cvds.samples.entities.Equipo;
import edu.eci.cvds.samples.services.ExcepcionServiciosLaboratorio;
import edu.eci.cvds.samples.services.ServiciosLaboratorio;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;

public class ServiciosLaboratorioImpl implements ServiciosLaboratorio {
    @Inject
    private ElementoDAO elementoDAO;
    @Inject
    private EquipoDAO equipoDAO;

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
}
