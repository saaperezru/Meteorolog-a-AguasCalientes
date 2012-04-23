package org.meteorologaaguascalientes.dao;

import org.meteorologaaguascalientes.da.DataAccessAdapter;
import org.meteorologaaguascalientes.da.DataAccessException;
import org.meteorologaaguascalientes.vo.ValueObject;

public interface CrudDao<E, F extends ValueObject> {

    public F insert(DataAccessAdapter<E> adapter, F vo) throws DataAccessException;

    public F update(DataAccessAdapter<E> adapter, F vo) throws DataAccessException;

    public void delete(DataAccessAdapter<E> adapter, Object id) throws DataAccessException;

    public F findById(DataAccessAdapter<E> adapter, Object id) throws DataAccessException;
}
