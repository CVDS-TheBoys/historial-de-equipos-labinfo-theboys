package edu.eci.cvds.samples.services;

import org.apache.ibatis.exceptions.PersistenceException;

public class ExcepcionServiciosLaboratorio extends Exception {
    public ExcepcionServiciosLaboratorio(String message, PersistenceException ex) {
        super(message);
    }
    public ExcepcionServiciosLaboratorio(String message) {
        super(message);
    }
}
