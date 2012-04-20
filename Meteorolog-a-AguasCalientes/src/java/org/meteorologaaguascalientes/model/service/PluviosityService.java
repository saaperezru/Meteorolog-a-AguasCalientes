/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.model.service;

import org.meteorologaaguascalientes.dao.DaoFactory;
import org.meteorologaaguascalientes.model.vo.Pluviosity;

/**
 *
 * @author Administrator
 */
public class PluviosityService extends VariableService<Pluviosity> {

    public PluviosityService() {
        super(DaoFactory.getPluviosityDaoInstance());
    }

    @Override
    public void checkVaraible(Pluviosity object) {
        if (object == null) {
            throw new NullPointerException("Temperature cannot be Null");
        }
        if (object.getSample() == null) {
            throw new NullPointerException("Sample temperature cannot be Null");
        }
         //TODO check for more bussines Logic
    }
}
