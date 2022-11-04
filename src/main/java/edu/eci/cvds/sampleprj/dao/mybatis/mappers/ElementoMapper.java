package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import edu.eci.cvds.samples.entities.Elemento;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ElementoMapper {
    public Elemento consultarElemento(@Param("idele") int id);
    public List<Elemento> consultarElementos();
    public void insertarElemento(@Param("elem") Elemento elemento);
    public List<Elemento> consultarElementosConNovedades();
}
