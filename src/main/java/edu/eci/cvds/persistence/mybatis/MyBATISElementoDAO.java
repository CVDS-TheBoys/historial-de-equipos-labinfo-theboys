package edu.eci.cvds.persistence.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.persistence.ElementoDAO;
import edu.eci.cvds.persistence.mybatis.mappers.ElementoMapper;
import edu.eci.cvds.entities.Elemento;

import org.apache.ibatis.exceptions.PersistenceException;
import java.util.List;

public class MyBATISElementoDAO implements ElementoDAO {
    @Inject
    private ElementoMapper elementoMapper;

    @Override
    public Elemento load(int id) throws PersistenceException {
        try {
            return elementoMapper.consultarElemento(id);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new org.apache.ibatis.exceptions.PersistenceException("Error al consultar los elemento" + id + e);
        }
    }

    @Override
    public void save(Elemento elemento) throws PersistenceException {
        try {
            elementoMapper.insertarElemento(elemento);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            System.out.println(e.getMessage());
            throw new org.apache.ibatis.exceptions.PersistenceException("Error al registrar el elemento " + elemento.toString(), e);
        }
    }

    @Override
    public List<Elemento> loadAll() throws PersistenceException {
        try {
            return elementoMapper.consultarElementos();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new org.apache.ibatis.exceptions.PersistenceException("Error al consultar los elementos disponibles " + e);
        }
    }

    @Override
    public List<Elemento> loadWithNovedades() throws PersistenceException {
        try {
            return elementoMapper.consultarElementosConNovedades();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new org.apache.ibatis.exceptions.PersistenceException("Error al consultar los elementos disponibles " + e);
        }
    }

    @Override
    public List<Elemento> loadWithNovedades(int id) throws PersistenceException {
        try {
            return elementoMapper.consultarEquipoElementosConNovedades(id);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new org.apache.ibatis.exceptions.PersistenceException("Error al consultar los elementos disponibles " + e);
        }
    }

    @Override
    public void updatePC(int idel, int ideq) throws PersistenceException {
        try {
            elementoMapper.actualizarEquipo(idel, ideq);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            System.out.println(e.getMessage());
            throw new org.apache.ibatis.exceptions.PersistenceException("Error al actualizar el equipo del elemento " + idel, e);
        }
    }

    @Override
    public List<Elemento> loadAvailableElementsType(String tipo) throws PersistenceException {
        try {
            return elementoMapper.consultarTipoElementosDisponibles(tipo);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new org.apache.ibatis.exceptions.PersistenceException("Error al consultar los elementos disponibles de tipo" + tipo + e);
        }
    }
}
