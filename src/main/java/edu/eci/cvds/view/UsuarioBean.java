package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.services.ExcepcionServiciosLaboratorio;
import edu.eci.cvds.services.ServiciosUsuario;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@SuppressWarnings("deprecation")
@ManagedBean(name = "UsuarioBean")
@SessionScoped
public class UsuarioBean extends BasePageBean {
    @Inject
    private ServiciosUsuario serviciosUsuario;
    private Usuario usuario = null;

    public String login(String email, String password) {
        Usuario user;
        String redirect = null;
        try {
            user = serviciosUsuario.consultarUsuario(email, password);
            if (user != null) {
                usuario = user;
                redirect = "menu?faces-redirect=true";
            } else {
                usuario = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales incorrectas"));
            }
        } catch (ExcepcionServiciosLaboratorio e) {
            throw new RuntimeException(e);
        }
        return redirect;
    }

    public String logout() {
        usuario = null;
        return "login?faces-redirect=true";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
