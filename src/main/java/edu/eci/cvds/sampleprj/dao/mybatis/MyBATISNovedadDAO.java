package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.NovedadDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.NovedadMapper;
import edu.eci.cvds.samples.entities.Novedad;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.ArrayList;

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
}
