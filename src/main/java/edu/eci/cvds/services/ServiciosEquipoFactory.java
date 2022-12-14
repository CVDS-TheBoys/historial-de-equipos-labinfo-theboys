package edu.eci.cvds.services;

import com.google.inject.Injector;
import edu.eci.cvds.persistence.EquipoDAO;
import edu.eci.cvds.persistence.mybatis.*;
import edu.eci.cvds.services.impl.ServiciosEquipoImpl;
import org.mybatis.guice.XMLMyBatisModule;

import java.util.Optional;

import static com.google.inject.Guice.createInjector;

public class ServiciosEquipoFactory {
    private static ServiciosEquipoFactory instance = new ServiciosEquipoFactory();
    private static Optional<Injector> optInjector;

    private Injector myBatisInjector(String env, String pathResource) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId(env);
                setClassPathResource(pathResource);
                bind(EquipoDAO.class).to(MyBATISEquipoDAO.class);
                bind(ServiciosEquipo.class).to(ServiciosEquipoImpl.class);
            }
        });
    }

    private ServiciosEquipoFactory(){
        optInjector = Optional.empty();
    }

    public ServiciosEquipo getServiciosEquipo(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }
        return optInjector.get().getInstance(ServiciosEquipo.class);
    }

    public ServiciosEquipo getServiciosEquipoTesting(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
        }
        return optInjector.get().getInstance(ServiciosEquipo.class);
    }

    public static ServiciosEquipoFactory getInstance(){
        return instance;
    }
}
