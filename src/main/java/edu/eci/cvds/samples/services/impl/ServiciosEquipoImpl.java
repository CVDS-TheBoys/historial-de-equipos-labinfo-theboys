package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.EquipoDAO;
import edu.eci.cvds.samples.entities.Equipo;
import edu.eci.cvds.samples.services.ExcepcionServiciosLaboratorio;
import edu.eci.cvds.samples.services.ServiciosEquipo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServiciosEquipoImpl implements ServiciosEquipo {

    private ArrayList<Boolean> estados;

    @Inject
    private EquipoDAO equipoDAO;

    @Override
    public List<Equipo> consultarEquipos() throws ExcepcionServiciosLaboratorio {
        return equipoDAO.loadAll();
    }

    @Override
    public void registrarEquipo(Equipo equipo) throws ExcepcionServiciosLaboratorio {
        equipoDAO.save(equipo);
    }

    @Override
    public List<Equipo> consultarReporte() throws ExcepcionServiciosLaboratorio {
        return equipoDAO.consultarReporte();
    }

}
