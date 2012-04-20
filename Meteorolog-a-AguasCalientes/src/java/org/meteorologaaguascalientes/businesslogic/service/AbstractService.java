
package org.meteorologaaguascalientes.businesslogic.service;

import java.util.List;
import org.meteorologaaguascalientes.da.DataAccessAdapter;
import org.meteorologaaguascalientes.da.DataAccessException;
import org.meteorologaaguascalientes.dao.VariableDao;
import org.meteorologaaguascalientes.vo.ValueObject;

public abstract class AbstractService<E extends ValueObject> {
	private String visibleName;

	public E createRecord(DataAccessAdapter dataAccess,E record) throws DataAccessException{
		return getDao(dataAccess).insert(dataAccess, record);
	}

	

	protected abstract VariableDao<?,E> getDao(DataAccessAdapter dataAccess);

	public void setVisibleName(String visibleName) {
		this.visibleName = visibleName;
	}

	public String getVisibleName() {
		return visibleName;
	}
}
