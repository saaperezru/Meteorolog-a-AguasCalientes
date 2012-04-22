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
		variableDaos.put(VariablesVoFactory.ATMOSPHERIC_PRESSURE, new JpaDaoAtmosphericPressure());
		variableDaos.put(VariablesVoFactory.PLUVIOSITY, new JpaDaoPluviosity());
		variableDaos.put(VariablesVoFactory.TEMPERATURE, new JpaDaoTemperature());
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
