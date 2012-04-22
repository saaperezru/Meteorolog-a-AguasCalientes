/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.control.forecast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author juan
 */
public class ForecastsFactory {
    
    private static ForecastsFactory instance = null;
    private HashMap<String, Forecast> forecasts = null;
    
    public static final String DEFAULT = "default";
    
    private ForecastsFactory() {

        forecasts = new HashMap<String, Forecast>();

        forecasts.put(DEFAULT, new DefaultForecastImpl());
        
    }

    public static ForecastsFactory getInstance() {
        if (instance == null) {
            instance = new ForecastsFactory();
        }
        return instance;
    }
    
    public Forecast getForecastById(String key){
        return forecasts.get(key);
    }
    
    public List<Forecast> getForecasts(){
        return ForecastsFactory.getInstance().forecastsList();
    }
    
    private List<Forecast> forecastsList(){
        return new ArrayList<Forecast>(forecasts.values());
    }
    
    public ArrayList<String> getForecastsKeys(){
        ArrayList<String> list = new ArrayList<String>();

        for (Object measure : forecasts.keySet().toArray()) {
            list.add((String) measure);
        }
        return list;
    }
}
