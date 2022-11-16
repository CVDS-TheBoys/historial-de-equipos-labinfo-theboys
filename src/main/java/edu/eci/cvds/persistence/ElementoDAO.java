package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Elemento;

import org.apache.ibatis.exceptions.PersistenceException;
import java.util.List;

public interface ElementoDAO {
    public Elemento load(int id) throws PersistenceException;
    public void save(Elemento elemento) throws PersistenceException;
    public List<Elemento> loadAll() throws PersistenceException;
    public List<Elemento> loadWithNovedades() throws PersistenceException;
    public List<Elemento> loadWithNovedades(int id) throws PersistenceException;
    public void updatePC(int idel, Integer ideq) throws PersistenceException;
    public List<Elemento> loadAvailableElementsType(String tipo) throws PersistenceException;
    public List<Elemento> loadAvailableElements() throws PersistenceException;
    public void disableElement(int idel) throws PersistenceException;
}
