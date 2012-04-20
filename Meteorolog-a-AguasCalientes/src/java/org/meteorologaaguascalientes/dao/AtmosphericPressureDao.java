/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.dao;

import org.meteorologaaguascalientes.model.vo.AtmosphericPressure;

/**
 *
 * @author tuareg
 */
public class AtmosphericPressureDao extends AbstractVariableDao<AtmosphericPressure> {

    private static AtmosphericPressureDao instance;

    public synchronized static AtmosphericPressureDao getInstance() {
        if (instance == null) {
            instance = new AtmosphericPressureDao();
        }
        return instance;
    }
}
