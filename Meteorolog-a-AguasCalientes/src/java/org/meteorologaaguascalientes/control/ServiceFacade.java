/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.control;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.meteorologaaguascalientes.dao.Dao;
import org.meteorologaaguascalientes.dao.DaoFactory;
import org.meteorologaaguascalientes.model.service.ServiceFactory;
import org.meteorologaaguascalientes.model.vo.AtmosphericPressure;
import org.meteorologaaguascalientes.model.vo.Pluviosity;
import org.meteorologaaguascalientes.model.vo.Sample;
import org.meteorologaaguascalientes.model.vo.Temperature;

/**
 *
 * @author Administrator
 */
public class ServiceFacade {
    
    public boolean insertValues(Map<String,String> data){
        //check for null keys or null values
        if(checkNullElements(data.keySet().toArray()))
           return false;
        if(checkNullElements(data.values().toArray()))
           return false;
        
        //checking time
        String timestring = data.get("sample");
        Date time;
        try{
            time = (new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa")).parse(timestring);
            Calendar c = Calendar.getInstance();
            c.setTime(time);
            if(c.get(Calendar.YEAR) < 1000){
                throw new Exception();
            }
        }catch(Exception e){
            return false;
        }
	
        Sample sample = new Sample(time);
        
        double val;
        
        //checking temperature
        String temperaturaString = data.get("temperature");
        try{
            val = Double.parseDouble(temperaturaString);
        }catch(NumberFormatException e){
            return false;
        }
        Temperature temperature = new Temperature();
        temperature.setValue(val);
        temperature.setSample(sample);
        
        //checking pluviosity
        String pluviosityString = data.get("pluviosity");
        try{
            val = Double.parseDouble(pluviosityString);
        }catch(NumberFormatException e){
            return false;
        }
        Pluviosity pluviosity = new Pluviosity();
        pluviosity.setValue(val);
        pluviosity.setSample(sample);
        
        //checking atmosphericPressure
        String atmosphericPressureString = data.get("atmosphericPressure");
        try{
            val = Double.parseDouble(atmosphericPressureString);
        }catch(NumberFormatException e){
            return false;
        }
        AtmosphericPressure atmosphericPressure = new AtmosphericPressure();
        atmosphericPressure.setValue(val);
        atmosphericPressure.setSample(sample);
        
        //Saving
        if (!ServiceFactory.getSampleService().create(sample))
		return false;
        ServiceFactory.getTemperatureService().create(temperature);
        ServiceFactory.getPluviosityService().create(pluviosity);
        ServiceFactory.getAtmosphericPressureService().create(atmosphericPressure);
        return true; 
    }
    
    private boolean checkNullElements(Object[] list){
        for (Object element: list)
            if(element == null)
                return true;
        return false;
    }
    
}
