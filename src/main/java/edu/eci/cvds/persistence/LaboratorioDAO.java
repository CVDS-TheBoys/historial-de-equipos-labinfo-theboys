package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Laboratorio;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.ArrayList;

public interface LaboratorioDAO {
    public void save(Laboratorio lb) throws PersistenceException;
    public Laboratorio load(int id) throws PersistenceException;
    public ArrayList<Laboratorio> loadAll() throws PersistenceException;
}
