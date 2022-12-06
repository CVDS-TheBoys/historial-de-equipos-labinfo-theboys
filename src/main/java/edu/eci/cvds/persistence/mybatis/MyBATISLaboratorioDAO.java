package edu.eci.cvds.persistence.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.persistence.LaboratorioDAO;
import edu.eci.cvds.persistence.mybatis.mappers.LaboratorioMapper;
import org.apache.ibatis.exceptions.PersistenceException;

import java.sql.Date;
import java.util.List;

public class MyBATISLaboratorioDAO implements LaboratorioDAO {
    @Inject
    private LaboratorioMapper laboratorioMapper;

    @Override
    public void save(Laboratorio laboratorio) throws PersistenceException {
        try {
            laboratorioMapper.insertarLaboratorio(laboratorio);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            System.out.println(e.getMessage());
            throw new org.apache.ibatis.exceptions.PersistenceException(
                    "Error al registrar laboratorio " + laboratorio.toString() + ": ", e);
        }
    }

    @Override
    public Laboratorio load(int id) throws PersistenceException {
        try {
            return laboratorioMapper.consultarLaboratorio(id);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            System.out.println(e.getMessage());
            throw new org.apache.ibatis.exceptions.PersistenceException("Error al consultar laboratorio " + id + ": ",
                    e);
        }
    }

    @Override
    public List<Laboratorio> loadAll() throws PersistenceException {
        try {
            return laboratorioMapper.consultarLaboratorios();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            System.out.println(e.getMessage());
            throw new org.apache.ibatis.exceptions.PersistenceException("Error al consultar laboratorios: ", e);
        }
    }

    @Override
    public void closeLab(int id, Date fecha_cierre) throws PersistenceException {
        try {
            laboratorioMapper.cerrarLaboratorio(id, fecha_cierre);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new org.apache.ibatis.exceptions.PersistenceException("Error al cerrar laboratorio: " + id + e);
        }
    }

}
