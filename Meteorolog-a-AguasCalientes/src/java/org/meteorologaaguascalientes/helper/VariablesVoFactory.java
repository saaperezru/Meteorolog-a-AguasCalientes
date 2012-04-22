package org.meteorologaaguascalientes.helper;

import java.util.HashMap;
import org.meteorologaaguascalientes.vo.AtmosphericPressureVo;
import org.meteorologaaguascalientes.vo.PluviosityVo;
import org.meteorologaaguascalientes.vo.TemperatureVo;
import org.meteorologaaguascalientes.vo.VariableVo;

public class VariablesVoFactory {

	private abstract class CreateVariableVoBehaviour{
		public abstract VariableVo getNewVo();
	}

	private static VariablesVoFactory instance = null;
	private HashMap<String,CreateVariableVoBehaviour> createBehaviours = new HashMap<String, CreateVariableVoBehaviour>();

	private VariablesVoFactory() {
		createBehaviours.put(PLUVIOSITY, new CreateVariableVoBehaviour() {

			@Override
			public VariableVo getNewVo() {
				return new PluviosityVo();
			}
		});
		
		createBehaviours.put(ATMOSPHERIC_PRESSURE, new CreateVariableVoBehaviour() {

			@Override
			public VariableVo getNewVo() {
				return new AtmosphericPressureVo();
			}
		});

		createBehaviours.put(TEMPERATURE, new CreateVariableVoBehaviour() {

			@Override
			public VariableVo getNewVo() {
				return new TemperatureVo();
			}
		});

	}

	private synchronized static VariablesVoFactory getInstance(){
		if(instance == null){
			instance = new VariablesVoFactory();
		}
		return instance;
	}
		

	public static final String PLUVIOSITY = "pluviosity";
	public static final String ATMOSPHERIC_PRESSURE = "atmosphericPressure";
	public static final String TEMPERATURE = "temperature";
	private static final String[] VARIABLES_NAMES = {PLUVIOSITY, ATMOSPHERIC_PRESSURE, TEMPERATURE};

	public static String[] getVariableTypes() {
		return VARIABLES_NAMES;
	}

	public HashMap<String,CreateVariableVoBehaviour> getVoCreateBehaviourMap(){
		return createBehaviours;
	}

	public static VariableVo getVo(String type){
		HashMap<String, CreateVariableVoBehaviour> map = getInstance().getVoCreateBehaviourMap();
		if (map.containsKey(type)){
			return map.get(type).getNewVo();
		}
		return null;
	}
}
