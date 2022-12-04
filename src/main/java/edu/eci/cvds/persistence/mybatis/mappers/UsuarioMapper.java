package edu.eci.cvds.persistence.mybatis.mappers;

import edu.eci.cvds.entities.Usuario;
import org.apache.ibatis.annotations.Param;

public interface UsuarioMapper {
    public Usuario consultarUsuario(@Param("email") String email, @Param("contra") String contra);
}
