/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.meteorologaaguascalientes.model.Sample;

/**
 *
 * @author tuareg
 */
public class DaoList {

    private HashMap<String, Dao> daoList = new HashMap<String, Dao>();
    private HashMap<String, AbstractVariableDao> variablesDao = new HashMap<String, AbstractVariableDao>();
    private static DaoList instance;

    private DaoList() {
        Dao<Sample> dao = new SampleDao();
        daoList.put("sample", dao);

        AbstractVariableDao daoV = new PluviosityDao();
        String variableName = "pluviosity";
        daoList.put(variableName, daoV);
        variablesDao.put(variableName, daoV);

        daoV = new TemperatureDao();
        variableName = "temperature";
        daoList.put(variableName, daoV);
        variablesDao.put(variableName, daoV);

        daoV = new AtmosphericPressureDao();
        variableName = "atmosphericPressure";
        daoList.put(variableName, daoV);
        variablesDao.put(variableName, daoV);

    }

    public HashMap<String, Dao> getDaoMap() {
        return daoList;
    }

    public HashMap<String, AbstractVariableDao> getVariablesDaoMap() {
        return variablesDao;
    }

    public static List<Dao> getDao() {
        return new ArrayList<Dao>(DaoList.getInstance().getDaoMap().values());
    }

    public static List<AbstractVariableDao> getVariables() {
        return new ArrayList<AbstractVariableDao>(DaoList.getInstance().getVariablesDaoMap().values());
    }

    public synchronized static DaoList getInstance() {

        while (instance == null) {
            instance = new DaoList();
        }

        return instance;

    }
}
