/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.dao;

import java.util.ArrayList;
import java.util.List;
import org.meteorologaaguascalientes.model.vo.Variable;

/**
 *
 * @author tuareg
 */
public abstract class AbstractVariableDao<E extends Variable> implements Dao<E> {

    protected ArrayList<E> data = new ArrayList<E>();
    protected E lastRecord;

    @Override
    public boolean createRecord(E record) {
        boolean add = data.add(record);
        if (lastRecord == null) {
            lastRecord = record;
        } else {
            if (lastRecord.getSample().getTime().compareTo(record.getSample().getTime()) <= 0) {
                lastRecord = record;
            }
        }
        return true;
    }

    public E getLastValue() {
        return lastRecord;
    }

    public List<E> getAllValues() {
        return data;
    }
}
