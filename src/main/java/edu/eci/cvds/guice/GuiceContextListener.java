package edu.eci.cvds.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import edu.eci.cvds.persistence.ElementoDAO;
import edu.eci.cvds.persistence.EquipoDAO;
import edu.eci.cvds.persistence.LaboratorioDAO;
import edu.eci.cvds.persistence.NovedadDAO;
import edu.eci.cvds.persistence.mybatis.*;
import edu.eci.cvds.services.ServiciosElemento;
import edu.eci.cvds.services.ServiciosEquipo;
import edu.eci.cvds.services.ServiciosLaboratorio;
import edu.eci.cvds.services.impl.ServiciosElementoImpl;
import edu.eci.cvds.services.impl.ServiciosEquipoImpl;
import edu.eci.cvds.services.ServiciosNovedad;
import edu.eci.cvds.services.impl.ServiciosLaboratorioImpl;
import edu.eci.cvds.services.impl.ServiciosNovedadImpl;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class GuiceContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.MySQL);
                setEnvironmentId("development");
                setClassPathResource("mybatis-config.xml");

                bind(ElementoDAO.class).to(MyBATISElementoDAO.class);
                bind(EquipoDAO.class).to(MyBATISEquipoDAO.class);
                bind(ServiciosElemento.class).to(ServiciosElementoImpl.class);
                bind(ServiciosEquipo.class).to(ServiciosEquipoImpl.class);
                bind(NovedadDAO.class).to(MyBATISNovedadDAO.class);
                bind(ServiciosNovedad.class).to(ServiciosNovedadImpl.class);
                bind(LaboratorioDAO.class).to(MyBATISLaboratorioDAO.class);
                bind(ServiciosLaboratorio.class).to(ServiciosLaboratorioImpl.class);
            }
        });
        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }
}