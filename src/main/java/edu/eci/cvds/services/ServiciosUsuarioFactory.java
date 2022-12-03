package edu.eci.cvds.services;

import com.google.inject.Injector;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.persistence.mybatis.MyBATISUsuarioDAO;
import edu.eci.cvds.services.impl.ServiciosUsuarioImpl;
import org.mybatis.guice.XMLMyBatisModule;

import java.util.Optional;

import static com.google.inject.Guice.createInjector;

public class ServiciosUsuarioFactory {
    private static ServiciosUsuarioFactory instance = new ServiciosUsuarioFactory();

    private static Optional<Injector> optInjector;

    private Injector myBatisInjector(String env, String pathResource) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId(env);
                setClassPathResource(pathResource);
                bind(UsuarioDAO.class).to(MyBATISUsuarioDAO.class);
                bind(ServiciosUsuario.class).to(ServiciosUsuarioImpl.class);
            }
        });
    }

    private ServiciosUsuarioFactory(){
        optInjector = Optional.empty();
    }

    public ServiciosUsuario getServiciosUsuario(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }
        return optInjector.get().getInstance(ServiciosUsuario.class);
    }

    public ServiciosUsuario getServiciosUsuarioTesting(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
        }
        return optInjector.get().getInstance(ServiciosUsuario.class);
    }

    public static ServiciosUsuarioFactory getInstance(){
        return instance;
    }
}
