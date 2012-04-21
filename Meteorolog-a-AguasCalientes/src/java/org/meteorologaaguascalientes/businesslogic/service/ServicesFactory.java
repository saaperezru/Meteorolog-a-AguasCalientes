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

    private HashMap<String, AbstractVariableService> variablesService = new HashMap<String, AbstractVariableService>();
    private static ServicesFactory instance;

    private ServicesFactory() {

        AbstractVariableService daoV = new PluviosityService();
        variablesService.put(PLUVIOSITY, daoV);

        daoV = new TemperatureService();
        variablesService.put(TEMPERATURE, daoV);

        daoV = new AtmosphericPressureService();
        variablesService.put(ATMOSPHERIC_PRESSURE, daoV);

    }

    public HashMap<String,AbstractVariableService> getVariablesServicesMap() {
	   return variablesService;
    }

    public static List<AbstractVariableService> getVariablesServices() {
        return new ArrayList<AbstractVariableService>(ServicesFactory.getInstance().getVariablesServicesMap().values());
    }
    
    public AbstractVariableService getVariableServiceByKey(String key){
        if(key == null)
            return null;
        return variablesService.get(key);
    }

    public synchronized static ServicesFactory getInstance() {

        while (instance == null) {
            instance = new ServicesFactory();
        }

        return instance;

    }
}
