/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.dao;

import org.meteorologaaguascalientes.model.vo.Temperature;

/**
 *
 * @author tuareg
 */
public class TemperatureDao extends AbstractVariableDao<Temperature> {
    
    private static TemperatureDao instance;

    public synchronized static TemperatureDao getInstance() {
        if (instance == null) {
            instance = new TemperatureDao();
        }
        return instance;
    }
}
