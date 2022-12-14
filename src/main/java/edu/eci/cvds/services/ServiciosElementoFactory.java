package edu.eci.cvds.services;

import com.google.inject.Injector;
import edu.eci.cvds.persistence.ElementoDAO;
import edu.eci.cvds.persistence.EquipoDAO;
import edu.eci.cvds.persistence.mybatis.*;
import edu.eci.cvds.services.impl.ServiciosElementoImpl;
import edu.eci.cvds.services.impl.ServiciosEquipoImpl;
import org.mybatis.guice.XMLMyBatisModule;

import java.util.Optional;

import static com.google.inject.Guice.createInjector;

public class ServiciosElementoFactory {

    private static ServiciosElementoFactory instance = new ServiciosElementoFactory();

    private static Optional<Injector> optInjector;

    private Injector myBatisInjector(String env, String pathResource) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId(env);
                setClassPathResource(pathResource);
                bind(ElementoDAO.class).to(MyBATISElementoDAO.class);
                bind(EquipoDAO.class).to(MyBATISEquipoDAO.class);
                bind(ServiciosEquipo.class).to(ServiciosEquipoImpl.class);
                bind(ServiciosElemento.class).to(ServiciosElementoImpl.class);
                // TODO bind de DAOs/servicios faltantes
            }
        });
    }

    private ServiciosElementoFactory(){
        optInjector = Optional.empty();
    }

    public ServiciosElemento getServiciosElemento(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }
        return optInjector.get().getInstance(ServiciosElemento.class);
    }

    public ServiciosElemento getServiciosElementoTesting(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
        }
        return optInjector.get().getInstance(ServiciosElemento.class);
    }

    public static ServiciosElementoFactory getInstance(){
        return instance;
    }

}
