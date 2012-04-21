/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.businesslogic.service;

import java.util.List;
import org.meteorologaaguascalientes.da.DataAccessAdapter;
import org.meteorologaaguascalientes.da.DataAccessException;
import org.meteorologaaguascalientes.dao.VariableDao;
import org.meteorologaaguascalientes.vo.VariableVo;

/**
 *
 * @author tuareg
 */
public abstract class AbstractVariableService<E extends VariableVo> {

    private String visibleName;

    public E createRecord(DataAccessAdapter dataAccess, E record) throws DataAccessException {
        return getDao(dataAccess).insert(dataAccess, record);
    }

    protected abstract VariableDao<?, E> getDao(DataAccessAdapter dataAccess);

    public void setVisibleName(String visibleName) {
        this.visibleName = visibleName;
    }

    public String getVisibleName() {
        return visibleName;
    }

    public E getLastValue(DataAccessAdapter dataAccess) throws DataAccessException {
        return getDao(dataAccess).getLastValue(dataAccess);
    }

    public List<E> getAllValues(DataAccessAdapter dataAccess) throws DataAccessException {
        return getDao(dataAccess).getAllValues(dataAccess);
    }
}
