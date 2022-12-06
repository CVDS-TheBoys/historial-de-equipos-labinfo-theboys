package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Usuario;
import org.apache.ibatis.exceptions.PersistenceException;

public interface UsuarioDAO {
    public Usuario load(String email, String contra) throws PersistenceException;
}
