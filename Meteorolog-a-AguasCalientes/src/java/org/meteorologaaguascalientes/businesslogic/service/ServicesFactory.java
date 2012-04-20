/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.businesslogic.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author tuareg
 */
public class ServicesFactory {

    public static final String PLUVIOSITY = "pluviosity";
    public static final String ATMOSPHERIC_PRESSURE = "atmosphericPressure";
    public static final String TEMPERATURE = "temperature";
    public static final String[] VARIABLES_NAMES = {PLUVIOSITY,ATMOSPHERIC_PRESSURE,TEMPERATURE};


    private HashMap<String, AbstractService> daoList = new HashMap<String, AbstractService>();
    private HashMap<String, AbstractVariableService> variablesDao = new HashMap<String, AbstractVariableService>();
    private static ServicesFactory instance;

    private ServicesFactory() {

        AbstractVariableService daoV = new PluviosityService();
        daoList.put(PLUVIOSITY, daoV);
        variablesDao.put(PLUVIOSITY, daoV);

        daoV = new TemperatureService();
        daoList.put(TEMPERATURE, daoV);
        variablesDao.put(TEMPERATURE, daoV);

        daoV = new AtmosphericPressureService();
        daoList.put(ATMOSPHERIC_PRESSURE, daoV);
        variablesDao.put(ATMOSPHERIC_PRESSURE, daoV);

    }

    public HashMap<String, AbstractService> getDaoMap() {
        return daoList;
    }

    public HashMap<String,AbstractVariableService> getVariablesServicesMap() {
	   return variablesDao;
    }

    public static List<AbstractService> getDao() {
        return new ArrayList<AbstractService>(ServicesFactory.getInstance().getDaoMap().values());
    }

    public static List<AbstractVariableService> getVariables() {
        return new ArrayList<AbstractVariableService>(ServicesFactory.getInstance().getVariablesServicesMap().values());
    }
    

    public synchronized static ServicesFactory getInstance() {

        while (instance == null) {
            instance = new ServicesFactory();
        }

        return instance;

    }
}
