package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.services.ExcepcionServiciosLaboratorio;
import edu.eci.cvds.services.ServiciosUsuario;
import org.apache.ibatis.exceptions.PersistenceException;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ServiciosUsuarioImpl implements ServiciosUsuario {
    @Inject
    private UsuarioDAO usuarioDAO;

    @Override
    public Usuario consultarUsuario(String email, String contra) throws ExcepcionServiciosLaboratorio {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(contra.getBytes());
            byte[] digest = md.digest();
            String hash = DatatypeConverter
                    .printHexBinary(digest).toUpperCase();
            return usuarioDAO.load(email, hash);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosLaboratorio("Error al cargar usuario " + ex);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
