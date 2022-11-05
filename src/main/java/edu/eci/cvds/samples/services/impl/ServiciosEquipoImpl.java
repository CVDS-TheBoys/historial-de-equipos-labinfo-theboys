package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.EquipoDAO;
import edu.eci.cvds.samples.entities.Equipo;
import edu.eci.cvds.samples.services.ExcepcionServiciosLaboratorio;
import edu.eci.cvds.samples.services.ServiciosEquipo;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;

public class ServiciosEquipoImpl implements ServiciosEquipo {
    @Inject
    private EquipoDAO equipoDAO;

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
    public List<Equipo> consultarReporte() throws ExcepcionServiciosLaboratorio {
        return equipoDAO.consultarReporte();
    }

}
