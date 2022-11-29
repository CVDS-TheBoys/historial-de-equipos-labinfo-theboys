package edu.eci.cvds.persistence.mybatis.mappers;

import edu.eci.cvds.entities.Laboratorio;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface LaboratorioMapper {
    public void insertarLaboratorio(@Param("laboratorio") Laboratorio laboratorio);
    public Laboratorio consultarLaboratorio(@Param("idlb") int id);
    public ArrayList<Laboratorio> consultarLaboratorios();
    public List<Laboratorio> consultarLaboratoriosDisponibles();
}
