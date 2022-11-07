package edu.eci.cvds.persistence.mybatis.mappers;

import edu.eci.cvds.entities.Equipo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EquipoMapper {
    public void insertarEquipo(@Param("equipo") Equipo equipo);
    public Equipo consultarEquipo(@Param("ideq") int id);
    public List<Equipo> consultarEquipos();
    public List<Equipo> consultarEquiposConNovedades();
    public List<Equipo> consultarReporte();
    public List<Equipo> consultarReporteFiltro(@Param("eq_id") int id, @Param("estado") boolean est, @Param("lab_id") int lab_id, @Param("nombre") String nombre);
}