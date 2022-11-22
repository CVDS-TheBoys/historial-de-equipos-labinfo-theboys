package edu.eci.cvds.persistence.mybatis.mappers;

import edu.eci.cvds.entities.Elemento;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ElementoMapper {
    public Elemento consultarElemento(@Param("idele") int id);
    public List<Elemento> consultarElementos();
    public void insertarElemento(@Param("elem") Elemento elemento);
    public List<Elemento> consultarElementosConNovedades();
    public List<Elemento> consultarEquipoElementosConNovedades(@Param("idequ") int id);
    public void actualizarEquipo(@Param("idel") int idel, @Param("ideq") Integer ideq);
    public List<Elemento> consultarTipoElementosDisponibles(@Param("tipo") String tipo);
    public List<Elemento> consultarElementosDisponibles();
    public void darBajaElemento(@Param("idele") int idel);
}
