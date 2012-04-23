package org.meteorologaaguascalientes.businesslogic.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.meteorologaaguascalientes.helper.VariablesVoFactory;

/**
 *
 * @author tuareg
 */
public class ServicesFactory {

    private HashMap<String, AbstractVariableService> variablesService = new HashMap<String, AbstractVariableService>();
    private static ServicesFactory instance;

    private ServicesFactory() {
        final String ATMOSPHERIC_PRESSURE = VariablesVoFactory.ATMOSPHERIC_PRESSURE;
        final String TEMPERATURE = VariablesVoFactory.TEMPERATURE;
        final String PLUVIOSITY = VariablesVoFactory.PLUVIOSITY;

        AbstractVariableService daoV = new PluviosityService(null, null);
        variablesService.put(PLUVIOSITY, daoV);

        daoV = new TemperatureService(null, null);
        variablesService.put(TEMPERATURE, daoV);

        daoV = new AtmosphericPressureService(null, null);
        variablesService.put(ATMOSPHERIC_PRESSURE, daoV);

    }

    public HashMap<String, AbstractVariableService> getVariablesServicesMap() {
        return variablesService;
    }

    public static List<AbstractVariableService> getVariablesServices() {
        return new ArrayList<AbstractVariableService>(ServicesFactory.getInstance().getVariablesServicesMap().values());
    }

    public AbstractVariableService getVariableServiceByKey(String key) {
        if (key == null) {
            return null;
        }
        return variablesService.get(key);
    }

    public synchronized static ServicesFactory getInstance() {

        while (instance == null) {
            instance = new ServicesFactory();
        }

        return instance;

    }
}
