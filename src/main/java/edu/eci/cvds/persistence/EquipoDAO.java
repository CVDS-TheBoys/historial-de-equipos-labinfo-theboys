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

    public List<Equipo> loadAvailableDevice() throws PersistenceException;

    public void disableDevice(int id) throws PersistenceException;

    public void updateLab(int ideq, Integer idlab) throws PersistenceException;

    public void removeLab(int ideq) throws PersistenceException;

    public List<Equipo> loadInLab(int idlab) throws PersistenceException;

    public List<Equipo> loadLabDevice(int id) throws PersistenceException;
}
