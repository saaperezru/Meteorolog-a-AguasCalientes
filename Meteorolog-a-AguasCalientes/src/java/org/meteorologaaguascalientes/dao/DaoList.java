/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.meteorologaaguascalientes.model.*;

/**
 *
 * @author tuareg
 */
public class DaoList {
	private static HashMap<String,Dao> daoList = new HashMap<String, Dao>();
	private static HashMap<String,AbstractVariableDao> variablesDao = new HashMap<String, AbstractVariableDao>(); 
	private static DaoList instance;

	public DaoList(){
		Dao<Sample> dao = new SampleDao();  
		daoList.put("Tiempo",dao);

		AbstractVariableDao daoV = new PluvisoityDao();  
		String variableName = "Pluviosidad";
		daoList.put(variableName,daoV);
		variablesDao.put(variableName,daoV);

		daoV = new TemperatureDao();  
		variableName = "Temperatura";
		daoList.put(variableName,daoV);
		variablesDao.put(variableName,daoV);

		daoV = new AtmosphericPressureDao();
		variableName = "Presión atmosférica";
		daoList.put(variableName,daoV);
		variablesDao.put(variableName,daoV);

	}
	
	public static  HashMap<String,Dao> getDao(){
		return daoList;
	}
	
	public static HashMap<String,AbstractVariableDao> getVariablesDao(){
		return variablesDao;
	}
		
	public synchronized static DaoList getInstance(){
		
		while (instance == null){
			instance = new DaoList();
		} 
		
		return instance;
		
	}
	
	
}
