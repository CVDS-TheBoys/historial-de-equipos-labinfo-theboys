package edu.eci.cvds.services;

import com.google.inject.Injector;
import edu.eci.cvds.persistence.NovedadDAO;
import edu.eci.cvds.persistence.mybatis.*;
import edu.eci.cvds.services.impl.ServiciosNovedadImpl;

import org.mybatis.guice.XMLMyBatisModule;

import java.util.Optional;

import static com.google.inject.Guice.createInjector;

public class ServiciosNovedadFactory {
    private static ServiciosNovedadFactory instance = new ServiciosNovedadFactory();
    private static Optional<Injector> optInjector;

    private Injector myBatisInjector(String env, String pathResource) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId(env);
                setClassPathResource(pathResource);
                bind(NovedadDAO.class).to(MyBATISNovedadDAO.class);
                bind(ServiciosNovedad.class).to(ServiciosNovedadImpl.class);
            }
        });
    }

    private ServiciosNovedadFactory() {
        optInjector = Optional.empty();
    }

    public ServiciosNovedad getServiciosNovedad() {
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development", "mybatis-config.xml"));
        }
        return optInjector.get().getInstance(ServiciosNovedad.class);
    }

    public ServiciosNovedad getServiciosNovedadTesting() {
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test", "mybatis-config-h2.xml"));
        }
        return optInjector.get().getInstance(ServiciosNovedad.class);
    }

    public static ServiciosNovedadFactory getInstance() {
        return instance;
    }
}
