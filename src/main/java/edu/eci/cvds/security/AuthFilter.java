package edu.eci.cvds.security;

import edu.eci.cvds.view.UsuarioBean;

import javax.annotation.processing.Filer;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Filtro basado en https://www.dataprix.com/es/blog-it/magm/login-y-control-acceso-basico-primefaces-paso-paso

@WebFilter(filterName = "AuthFilter", urlPatterns = {"*.xhtml"})
public class AuthFilter implements Filter {

    public AuthFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        // Obtengo el bean que representa el usuario desde el scope sesión
        UsuarioBean usuarioBean = (UsuarioBean) req.getSession().getAttribute("UsuarioBean");

        //Proceso la URL que está requiriendo el cliente
        String urlStr = req.getRequestURL().toString().toLowerCase();
        boolean noProteger = noProteger(urlStr);
        System.out.println(urlStr + " - desprotegido=[" + noProteger + "]");

        try {
            if (noProteger && usuarioBean.getUsuario() != null) {
                res.sendRedirect(req.getContextPath() + "/faces/menu.xhtml");
                return;
            }
        } catch (NullPointerException e) {
            if (noProteger) {
                chain.doFilter(request, response);
                return;
            }
        }

        //Si no requiere protección  continúo normalmente.
        if (noProteger) {
            chain.doFilter(request, response);
            return;
        }
        //El usuario no está logueado
        if (usuarioBean == null || usuarioBean.getUsuario() == null) {
            res.sendRedirect(req.getContextPath() + "/faces/login.xhtml");
            return;
        }

        //El recurso requiere protección, pero el usuario ya está logueado.
        chain.doFilter(request, response);
    }

    private boolean noProteger(String urlStr) {

        /*
         * Este es un buen lugar para colocar y programar todos los patrones que
         * creamos convenientes para determinar cuales de los recursos no
         * requieren protección. Sin duda que habría que crear un mecanismo tal
         * que se obtengan de un archivo de configuración o algo que no requiera
         * compilación.
         */
        if (urlStr.endsWith("login.xhtml"))
            return true;
        /*if (urlStr.indexOf("/javax.faces.resource/") != -1)
            return true;*/
        return false;
    }

    @Override
    public void destroy() {

    }
}
