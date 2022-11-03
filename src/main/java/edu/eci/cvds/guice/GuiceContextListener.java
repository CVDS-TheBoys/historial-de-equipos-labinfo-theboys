package edu.eci.cvds.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import edu.eci.cvds.sampleprj.dao.ElementoDAO;
import edu.eci.cvds.sampleprj.dao.EquipoDAO;
import edu.eci.cvds.sampleprj.dao.NovedadDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.MyBATISElementoDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.MyBATISEquipoDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.MyBATISNovedadDAO;
import edu.eci.cvds.samples.services.ServiciosElemento;
import edu.eci.cvds.samples.services.ServiciosNovedad;
import edu.eci.cvds.samples.services.impl.ServiciosElementoImpl;
import edu.eci.cvds.samples.services.impl.ServiciosNovedadImpl;

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
                // TODO Añadir entidades/servicios faltantes
                bind(NovedadDAO.class).to(MyBATISNovedadDAO.class);
                bind(ServiciosNovedad.class).to(ServiciosNovedadImpl.class);

            }
        });
        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }
}