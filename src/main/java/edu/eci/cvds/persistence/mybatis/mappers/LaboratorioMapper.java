package edu.eci.cvds.persistence.mybatis.mappers;

import edu.eci.cvds.entities.Laboratorio;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface LaboratorioMapper {
    public void insertarLaboratorio(@Param("laboratorio") Laboratorio laboratorio);

    public Laboratorio consultarLaboratorio(@Param("idlb") int id);

    public List<Laboratorio> consultarLaboratorios();

    public void cerrarLaboratorio(@Param("idlb") int id, @Param("fcierre") Date fecha_cierre);
}
