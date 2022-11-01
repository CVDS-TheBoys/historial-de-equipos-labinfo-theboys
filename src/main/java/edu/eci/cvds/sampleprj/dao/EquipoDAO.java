package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Equipo;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;

public interface EquipoDAO {
    public void save(Equipo e) throws PersistenceException;
    public Equipo load(int id) throws PersistenceException;
    public List<Equipo> loadAll() throws PersistenceException;
    public List<Equipo> consultarReporte() throws PersistenceException;

}
