package org.meteorologaaguascalientes.businesslogic.facade;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.meteorologaaguascalientes.businesslogic.service.AbstractVariableService;
import org.meteorologaaguascalientes.businesslogic.service.ServicesFactory;
import org.meteorologaaguascalientes.da.DataAccessAdapter;
import org.meteorologaaguascalientes.da.DataAccessException;
import org.meteorologaaguascalientes.helper.Config;
import org.meteorologaaguascalientes.vo.VariableVo;

/**
 *
 * @author jdbermeol
 */
public class ServiceFacade {

	public boolean insertValues(Map<String, String> data, String timestring) throws DataAccessException, Exception {
		if (data == null) {
			throw new Exception("Map data cannot be null");
		}
		if (timestring == null) {
			throw new Exception("String timestring cannot be null");
		}
		//check for null keys or null values
		if (checkNullElements(data.keySet().toArray())) {
			throw new Exception("There cannot be null keys in the Map data");
		}
		if (checkNullElements(data.values().toArray())) {
			throw new Exception("There cannot be null values in the Map data");
		}
		//checking time
		Date time;
		try {
			time = (new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa")).parse(timestring);
			Calendar c = Calendar.getInstance();
			c.setTime(time);
		} catch (Exception e) {
			throw e;
		}
		double val;
		DataAccessAdapter da = Config.getInstance().getDataAccessFactory().createDataAccess();
		da.beginTransaction();
		for (Entry<String, String> entry : data.entrySet()) {
			try {
				val = Double.parseDouble(entry.getValue());
			} catch (NumberFormatException e) {
				throw new Exception("The value provided for the variable " + entry.getKey() + " was not a valid Double");
			}
			AbstractVariableService avs = ServicesFactory.getInstance().getVariableServiceByKey(entry.getKey());
			VariableVo variableVo = avs.getNewVo();
			variableVo.setTime(time);
			variableVo.setValue(val);
			avs.createRecord(da, variableVo);
		}
		da.commit();
		da.close();
		return true;
	}

	private boolean checkNullElements(Object[] list) {
		for (Object element : list) {
			if (element == null) {
				return true;
			}
		}
		return false;
	}

	public HashMap<String, VariableVo> getLastValues() throws DataAccessException {
		DataAccessAdapter da = Config.getInstance().getDataAccessFactory().createDataAccess();
		HashMap<String, VariableVo> lastValues = new HashMap<String, VariableVo>();
		for (Entry<String, AbstractVariableService> e : ServicesFactory.getInstance().getVariablesServicesMap().entrySet()) {
			lastValues.put(e.getKey(), e.getValue().getLastValue(da));
		}
		return lastValues;
	}
}
