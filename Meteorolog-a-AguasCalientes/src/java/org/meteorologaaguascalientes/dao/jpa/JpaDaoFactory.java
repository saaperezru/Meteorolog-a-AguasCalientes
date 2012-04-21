package org.meteorologaaguascalientes.dao.jpa;

import java.util.HashMap;
import org.meteorologaaguascalientes.businesslogic.service.ServicesFactory;
import org.meteorologaaguascalientes.da.JpaDataAccess;
import org.meteorologaaguascalientes.dao.AbstractDaoFactory;
import org.meteorologaaguascalientes.dao.VariableDao;
import org.meteorologaaguascalientes.vo.AtmosphericPressureVo;
import org.meteorologaaguascalientes.vo.PluviosityVo;
import org.meteorologaaguascalientes.vo.TemperatureVo;

public class JpaDaoFactory extends AbstractDaoFactory<JpaDataAccess> {

	private static JpaDaoFactory instance = null;
	private HashMap<String, VariableDao> variableDaos = new HashMap<String, VariableDao>();

	private JpaDaoFactory() {
		variableDaos.put(ServicesFactory.ATMOSPHERIC_PRESSURE, new JpaDaoVariable<AtmosphericPressureVo>());
		variableDaos.put(ServicesFactory.PLUVIOSITY, new JpaDaoVariable<PluviosityVo>());
		variableDaos.put(ServicesFactory.TEMPERATURE, new JpaDaoVariable<TemperatureVo>());
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
