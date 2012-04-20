/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.control.historic;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.math3.exception.NoDataException;
import org.meteorologaaguascalientes.control.forecast.DefaultForecastImpl;
import org.meteorologaaguascalientes.businesslogic.service.AbstractVariableService;
import org.meteorologaaguascalientes.da.DataAccessException;
import org.meteorologaaguascalientes.da.JpaDataAccessFactory;
import org.meteorologaaguascalientes.vo.VariableVo;

/**
 *
 * @author juan
 */
public class HistoricControl {
    
    public List<SortedMap<Date, Double>> getData(AbstractVariableService variableDao) {
		try {
			List<SortedMap<Date, Double>> data = new ArrayList<SortedMap<Date, Double>>();
			
			SortedMap<Date, Double> actualValues = new TreeMap<Date, Double>();
			SortedMap<Date, Double> forecast = new TreeMap<Date, Double>();
			SortedMap<Long, Double> timeSpacedActualValues = new TreeMap<Long, Double>();
			SortedMap<Long, Double> timeSpacedForecast;
			
			data.add(actualValues);
		       JpaDataAccessFactory da = new JpaDataAccessFactory(JpaDataAccessFactory.PERSISTENCE_UNIT); 
			ArrayList<VariableVo> variables = (ArrayList<VariableVo>) variableDao.getAllValues(da.createDataAccess());
			
			for (VariableVo v : variables) {
			    actualValues.put(v.getTime(), v.getValue());
			}
			try{
			    Long firstSampleTime = actualValues.firstKey().getTime();
			    for (Date d : actualValues.keySet()) {
				timeSpacedActualValues.put(d.getTime() - firstSampleTime, actualValues.get(d));
			    }
			    if(actualValues.size()>2){
				timeSpacedForecast = new DefaultForecastImpl().forecast(10, timeSpacedActualValues);
				for (Long l:timeSpacedForecast.keySet()){
				    forecast.put(new Date(l + firstSampleTime), timeSpacedForecast.get(l));
				}
			    }
			}catch(NoSuchElementException e){
			}
			data.add(forecast);
			
			return data;
		} catch (DataAccessException ex) {
			Logger.getLogger(HistoricControl.class.getName()).log(Level.SEVERE, null, ex);
			//TODO : Change this.
			return null;
		}
    }
}
