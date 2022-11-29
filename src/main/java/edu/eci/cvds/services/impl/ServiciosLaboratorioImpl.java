package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.persistence.LaboratorioDAO;
import edu.eci.cvds.services.ExcepcionServiciosLaboratorio;
import edu.eci.cvds.services.ServiciosLaboratorio;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.ArrayList;
import java.util.List;

public class ServiciosLaboratorioImpl implements ServiciosLaboratorio {
    @Inject
    private LaboratorioDAO laboratorioDAO;

    @Override
    public ArrayList<Laboratorio> consultarLaboratorios() throws ExcepcionServiciosLaboratorio {
        try {
            return laboratorioDAO.loadAll();
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosLaboratorio("Error al cargar laboratorios " + ex);
        }
    }

    @Override
    public void registrarLaboratorio(Laboratorio laboratorio) throws ExcepcionServiciosLaboratorio {
        try {
            laboratorioDAO.save(laboratorio);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosLaboratorio("Error al registrar laboratorio " + laboratorio.getId() + ex);
        }
    }

    @Override
    public Laboratorio consultarLaboratorio(int id) throws ExcepcionServiciosLaboratorio {
        try {
            return laboratorioDAO.load(id);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosLaboratorio("Error al consultar laboratorio "+ id + ex);
        }
    }

    @Override
    public List<Laboratorio> consultarLaboratoriosDisponibles() throws ExcepcionServiciosLaboratorio {
        try {
            return laboratorioDAO.loadAvailable();
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosLaboratorio("Error al consultar laboratorios disponibles " + ex);
        }
    }
}
