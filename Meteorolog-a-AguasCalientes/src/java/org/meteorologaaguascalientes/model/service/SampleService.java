/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.model.service;

import org.meteorologaaguascalientes.dao.DaoFactory;
import org.meteorologaaguascalientes.model.vo.Sample;

/**
 *
 * @author Administrator
 */
public class SampleService {
    
    public void checkVaraible(Sample sample){
        
    }

    public boolean create(Sample record) {
        checkVaraible(record);
        return DaoFactory.getSampleDaoInstance().createRecord(record);
    }    
}
