package org.meteorologaaguascalientes.dao.jpa;

import java.util.HashMap;
import org.meteorologaaguascalientes.da.JpaDataAccess;
import org.meteorologaaguascalientes.dao.AbstractDaoFactory;
import org.meteorologaaguascalientes.dao.VariableDao;
import org.meteorologaaguascalientes.helper.VariablesVoFactory;

public class JpaDaoFactory extends AbstractDaoFactory<JpaDataAccess> {

    private static JpaDaoFactory instance = null;
    private HashMap<String, VariableDao> variableDaos = new HashMap<String, VariableDao>();

    private JpaDaoFactory() {
        final String ATMOSPHERIC_PRESSURE = VariablesVoFactory.ATMOSPHERIC_PRESSURE;
	final String TEMPERATURE = VariablesVoFactory.TEMPERATURE;
	final String PLUVIOSITY = VariablesVoFactory.PLUVIOSITY;
        variableDaos.put(VariablesVoFactory.ATMOSPHERIC_PRESSURE
                , new JpaDaoAtmosphericPressure("AtmosphericPressure",ATMOSPHERIC_PRESSURE));
        variableDaos.put(VariablesVoFactory.PLUVIOSITY
                , new JpaDaoPluviosity("Pluviosity",PLUVIOSITY));
        variableDaos.put(VariablesVoFactory.TEMPERATURE
                , new JpaDaoTemperature("Temperature",TEMPERATURE));
    }

    public static JpaDaoFactory getInstance() {
        if (instance == null) {
            instance = new JpaDaoFactory();
        }
        return instance;
    }

    @Override
    public VariableDao getVariableDao(String variableType) {
        if (variableDaos.containsKey(variableType)) {
            return variableDaos.get(variableType);
        }
        return null;
    }
}
