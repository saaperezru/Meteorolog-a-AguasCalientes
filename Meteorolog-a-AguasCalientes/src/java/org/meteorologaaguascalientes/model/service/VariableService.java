/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.model.service;

import java.util.List;
import org.meteorologaaguascalientes.dao.AbstractVariableDao;
import org.meteorologaaguascalientes.model.vo.Variable;

/**
 *
 * @author Administrator
 */
public abstract class VariableService<E extends Variable> {

    private AbstractVariableDao<E> dao;

    public VariableService(AbstractVariableDao<E> dao) {
        this.dao = dao;
    }
    
    public abstract void checkVaraible(E object);

    public Variable getLastRecord() {
        return dao.getLastValue();
    }

    public boolean create(E record) {
        checkVaraible(record);
        return dao.createRecord(record);
    }

    public List<E> getAllRecords() {
        return dao.getAllValues();
    }
}
