package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Equipo;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;

public interface EquipoDAO {
    public void save(Equipo e) throws PersistenceException;
    public Equipo load(int id) throws PersistenceException;
    public List<Equipo> loadAll() throws PersistenceException;
    public List<Equipo> loadWithNovedades() throws PersistenceException;
    public List<Equipo> consultarReporte() throws PersistenceException;

}