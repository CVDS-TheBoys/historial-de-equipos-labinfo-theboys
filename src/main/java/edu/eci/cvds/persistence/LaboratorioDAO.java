package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Laboratorio;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;

public interface LaboratorioDAO {
    public void save(Laboratorio lb) throws PersistenceException;

    public Laboratorio load(int id) throws PersistenceException;

    public List<Laboratorio> loadAll() throws PersistenceException;

    public void closeLab(int id) throws PersistenceException;
}
