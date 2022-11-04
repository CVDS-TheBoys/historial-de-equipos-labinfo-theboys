package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Novedad;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.ArrayList;

public interface NovedadDAO {
    public void save(Novedad nv) throws PersistenceException;
    public Novedad load(int id) throws PersistenceException;
    public ArrayList<Novedad> loadAll() throws PersistenceException;
}
