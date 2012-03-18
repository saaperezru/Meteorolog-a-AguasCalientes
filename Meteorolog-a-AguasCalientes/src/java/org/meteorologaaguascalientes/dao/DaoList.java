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
	private HashMap<String,Dao> daoList = new HashMap<String, Dao>();
	private HashMap<String,AbstractVariableDao> variablesDao = new HashMap<String, AbstractVariableDao>(); 
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
	
	public HashMap<String,Dao> getDaoMap(){
		return daoList;
	}
	
	public HashMap<String,AbstractVariableDao> getVariablesDaoMap(){
		return variablesDao;
	}

        public static List<Dao> getDao() {
                return new ArrayList<Dao>(DaoList.getInstance().getDaoMap().values());
        }
        public static List<AbstractVariableDao> getVariables() {
                return new ArrayList<AbstractVariableDao>(DaoList.getInstance().getVariablesDaoMap().values());
        }
		
	public synchronized static DaoList getInstance(){
		
		while (instance == null){
			instance = new DaoList();
		} 
		
		return instance;
		
	}
	
	
}
