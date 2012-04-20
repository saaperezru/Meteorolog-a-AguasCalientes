/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.dao;

import org.meteorologaaguascalientes.model.vo.Pluviosity;

/**
 *
 * @author tuareg
 */
public class PluviosityDao extends AbstractVariableDao<Pluviosity> {
    
    private static PluviosityDao instance;

    public synchronized static PluviosityDao getInstance() {
        if (instance == null) {
            instance = new PluviosityDao();
        }
        return instance;
    }
}
