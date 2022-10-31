package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import edu.eci.cvds.samples.entities.Novedad;
import org.apache.ibatis.annotations.Param;
import java.util.ArrayList;

public interface NovedadMapper {
    public void insertarNovedad(@Param("novedad") Novedad novedad);
    public Novedad consultarNovedad(@Param("idnv") int id);
    public ArrayList<Novedad> consultarNovedades();
}
