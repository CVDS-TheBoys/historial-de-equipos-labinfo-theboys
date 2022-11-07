package edu.eci.cvds.persistence.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.persistence.NovedadDAO;
import edu.eci.cvds.persistence.mybatis.mappers.NovedadMapper;
import edu.eci.cvds.entities.Novedad;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.ArrayList;
import java.util.List;

public class MyBATISNovedadDAO implements NovedadDAO {
    @Inject
    private NovedadMapper novedadMapper;

    @Override
    public void save(Novedad novedad) throws PersistenceException {
        try {
            novedadMapper.insertarNovedad(novedad);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            System.out.println(e.getMessage());
            throw new org.apache.ibatis.exceptions.PersistenceException("Error al registrar novedad " + novedad.toString() + ": ", e);
        }
    }

    @Override
    public Novedad load(int id) throws PersistenceException {
        try {
            return novedadMapper.consultarNovedad(id);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            System.out.println(e.getMessage());
            throw new org.apache.ibatis.exceptions.PersistenceException("Error al consultar novedad " + id + ": ", e);
        }
    }

    @Override
    public ArrayList<Novedad> loadAll() throws PersistenceException {
        try {
            return novedadMapper.consultarNovedades();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            System.out.println(e.getMessage());
            throw new org.apache.ibatis.exceptions.PersistenceException("Error al consultar novedades: ", e);
        }
    }

    @Override
    public List<Novedad> loadNovedadesElemento(int id) throws PersistenceException {
        try {
            return novedadMapper.consultarNovedadesElemento(id);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            System.out.println(e.getMessage());
            throw new org.apache.ibatis.exceptions.PersistenceException("Error al consultar novedades del elemento " + id + ": ", e);
        }
    }

    @Override
    public List<Novedad> loadNovedadesEquipo(int id) throws PersistenceException {
        try {
            return novedadMapper.consultarNovedadesEquipo(id);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            System.out.println(e.getMessage());
            throw new org.apache.ibatis.exceptions.PersistenceException("Error al consultar novedad del equipo " + id + ": ", e);
        }
    }
}
