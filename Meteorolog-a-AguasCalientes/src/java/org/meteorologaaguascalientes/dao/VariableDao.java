package org.meteorologaaguascalientes.dao;

import java.util.List;
import org.meteorologaaguascalientes.da.DataAccessAdapter;
import org.meteorologaaguascalientes.da.DataAccessException;
import org.meteorologaaguascalientes.vo.ValueObject;

public interface VariableDao<E, F extends ValueObject> extends Dao<E, F> {

	public F getLastValue(DataAccessAdapter<E> adapter) throws DataAccessException;

	public List<F> getLastNValues(DataAccessAdapter<E> adapter, int n) throws DataAccessException;

	public List<F> getAllValues(DataAccessAdapter<E> adapter) throws DataAccessException;
;
}
