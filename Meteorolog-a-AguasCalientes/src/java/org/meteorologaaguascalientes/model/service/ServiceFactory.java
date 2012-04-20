/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.model.service;

/**
 *
 * @author Administrator
 */
public class ServiceFactory {
    
    public static VariableService getTemperatureService(){
        return new TemperatureService();
    }
    
    public static VariableService getPluviosityService(){
        return new PluviosityService();
    }
    
    public static VariableService getAtmosphericPressureService(){
        return new AtmosphericPressureService();
    }
    
    public static SampleService getSampleService(){
        return new SampleService();
    }
}
