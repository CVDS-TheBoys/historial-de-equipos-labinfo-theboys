package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Elemento;

import org.apache.ibatis.exceptions.PersistenceException;
import java.util.List;

public interface ElementoDAO {
    public Elemento load(int id) throws PersistenceException;
    public void save(Elemento elemento) throws PersistenceException;
    public List<Elemento> loadAll() throws PersistenceException;
    public List<Elemento> loadWithNovedades() throws PersistenceException;
}
