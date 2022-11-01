package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.EquipoDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.EquipoMapper;
import edu.eci.cvds.samples.entities.Equipo;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;

public class MyBATISEquipoDAO implements EquipoDAO {
    @Inject
    private EquipoMapper equipoMapper;

    @Override
    public void save(Equipo equipo) throws PersistenceException {
        try {
            equipoMapper.insertarEquipo(equipo);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            System.out.println(e.getMessage());
            throw new org.apache.ibatis.exceptions.PersistenceException("Error al registrar el equipo " + equipo.toString(), e);
        }
    }

    @Override
    public Equipo load(int id) throws PersistenceException {
        try {
            return equipoMapper.consultarEquipo(id);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            System.out.println(e.getMessage());
            throw new org.apache.ibatis.exceptions.PersistenceException("Error al consultar el equipo " + id, e);
        }
    }

    @Override
    public List<Equipo> loadAll() throws PersistenceException {
        try {
            return equipoMapper.consultarEquipos();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            System.out.println(e.getMessage());
            throw new org.apache.ibatis.exceptions.PersistenceException("Error al consultar los equipos ", e);
        }
    }

    @Override
    public List<Equipo> consultarReporte() throws PersistenceException {
        try {
            return equipoMapper.consultarReporte();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            System.out.println(e.getMessage());
            throw new org.apache.ibatis.exceptions.PersistenceException("Error al consultar los reportes ", e);
        }
    }


}
