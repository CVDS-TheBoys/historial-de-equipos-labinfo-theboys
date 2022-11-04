package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import edu.eci.cvds.samples.entities.Elemento;
import org.apache.ibatis.annotations.Param;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface ElementoMapper {
    public List<Elemento> consultarElementos();
    public void insertarElemento(@Param("elem") Elemento elemento);
    public void actualizarEquipo(@Param("idel") int idel, @Param("ideq") int ideq);
    public List<Elemento> consultarTipoElementosDisponibles(@Param("tipo") String tipo);
    public Elemento consultarElemento(@Param("idel") int id);
}
