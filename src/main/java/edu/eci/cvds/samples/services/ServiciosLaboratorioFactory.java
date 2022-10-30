package edu.eci.cvds.samples.services;

import com.google.inject.Injector;
import edu.eci.cvds.sampleprj.dao.ElementoDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.MyBATISElementoDAO;
import edu.eci.cvds.samples.services.impl.ServiciosLaboratorioImpl;
import edu.eci.cvds.samples.services.impl.ServiciosLaboratorioStub;
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
                bind(ElementoDAO.class).to(MyBATISElementoDAO.class);
                // TODO bind de DAOs faltantes
                bind(ServiciosLaboratorio.class).to(ServiciosLaboratorioImpl.class);
            }
        });
    }

    /*private Injector stubInjector() {
        return createInjector(new com.google.inject.AbstractModule() {
            @Override
            protected void configure() {
                bind(ServiciosLaboratorio.class).to(ServiciosLaboratorioStub.class);
            }
        });
    }*/

    private ServiciosLaboratorioFactory(){
        optInjector = Optional.empty();
    }

    /*public ServiciosLaboratorio getServiciosLaboratorioStub(){
        optInjector = Optional.of(stubInjector());
        return optInjector.get().getInstance(ServiciosLaboratorio.class);
    }*/

    public ServiciosLaboratorio getServiciosLaboratorio(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test"/*"development"*/,"mybatis-config-h2.xml"/*"mybatis-config.xml"*/)); // BASE LOCAL
        }
        return optInjector.get().getInstance(ServiciosLaboratorio.class);
    }
    public ServiciosLaboratorio getServiciosLaboratorioTesting(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
        }
        return optInjector.get().getInstance(ServiciosLaboratorio.class);
    }
    public static ServiciosLaboratorioFactory getInstance(){
        return instance;
    }
}
