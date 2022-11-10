package edu.eci.cvds.services;

import com.google.inject.Injector;
import edu.eci.cvds.persistence.LaboratorioDAO;
import edu.eci.cvds.persistence.mybatis.MyBATISLaboratorioDAO;
import edu.eci.cvds.services.impl.ServiciosLaboratorioImpl;
import org.mybatis.guice.XMLMyBatisModule;

import java.util.Optional;

import static com.google.inject.Guice.createInjector;

public class ServiciosLaboratorioFactory {
    private static ServiciosLaboratorioFactory instance = new ServiciosLaboratorioFactory();
    private static Optional<Injector> optInjector;

    private Injector myBatisInjector(String env, String pathResource) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId(env);
                setClassPathResource(pathResource);
                bind(LaboratorioDAO.class).to(MyBATISLaboratorioDAO.class);
                bind(ServiciosLaboratorio.class).to(ServiciosLaboratorioImpl.class);
            }
        });
    }

    private ServiciosLaboratorioFactory() {
        optInjector = Optional.empty();
    }

    public ServiciosLaboratorio getServiciosLaboratorio() {
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development", "mybatis-config.xml"));
        }
        return optInjector.get().getInstance(ServiciosLaboratorio.class);
    }

    public ServiciosLaboratorio getServiciosLaboratorioTesting() {
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test", "mybatis-config-h2.xml"));
        }
        return optInjector.get().getInstance(ServiciosLaboratorio.class);
    }

    public static ServiciosLaboratorioFactory getInstance() {
        return instance;
    }
}
