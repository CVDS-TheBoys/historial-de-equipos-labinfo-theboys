package edu.eci.cvds.persistence.mybatis.mappers;

import edu.eci.cvds.entities.Novedad;
import org.apache.ibatis.annotations.Param;
import java.util.ArrayList;
import java.util.List;

public interface NovedadMapper {
    public void insertarNovedad(@Param("novedad") Novedad novedad);
    public Novedad consultarNovedad(@Param("idnv") int id);
    public ArrayList<Novedad> consultarNovedades();
    public List<Novedad> consultarNovedadesElemento(@Param("idele") int id);
    public List<Novedad> consultarNovedadesEquipo(@Param("idequ") int id);

}
