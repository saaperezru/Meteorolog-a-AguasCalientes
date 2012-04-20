/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.model.service;

import org.meteorologaaguascalientes.dao.DaoFactory;
import org.meteorologaaguascalientes.model.vo.AtmosphericPressure;

/**
 *
 * @author Administrator
 */
public class AtmosphericPressureService extends VariableService<AtmosphericPressure> {

    public AtmosphericPressureService() {
        super(DaoFactory.getAtmosphericPressureDaoInstance());
    }

    @Override
    public void checkVaraible(AtmosphericPressure object) {
        if( object == null)
            throw new NullPointerException("Temperature cannot be Null");
        if( object.getSample()== null)
            throw new NullPointerException("Sample temperature cannot be Null");
        //TODO check for more bussines Logic
    }
    
}
