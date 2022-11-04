package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.NovedadDAO;
import edu.eci.cvds.samples.entities.Novedad;
import edu.eci.cvds.samples.services.ExcepcionServiciosLaboratorio;
import edu.eci.cvds.samples.services.ServiciosNovedad;

import org.apache.ibatis.exceptions.PersistenceException;
import java.util.ArrayList;

public class ServiciosNovedadImpl implements ServiciosNovedad {
    @Inject
    private NovedadDAO novedadDAO;

    @Override
    public ArrayList<Novedad> consultarNovedades() throws ExcepcionServiciosLaboratorio {
        try {
            return novedadDAO.loadAll();
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosLaboratorio("Error al cargar novedades " + ex);
        }
    }

    @Override
    public void registrarNovedad(Novedad novedad) throws ExcepcionServiciosLaboratorio {
        try {
            novedadDAO.save(novedad);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosLaboratorio("Error al registrar novedad " + novedad.getId() + ex);
        }
    }
}
