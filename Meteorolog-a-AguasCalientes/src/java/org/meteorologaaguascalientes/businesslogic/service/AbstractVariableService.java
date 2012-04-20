/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.businesslogic.service;

import java.util.ArrayList;
import java.util.List;
import org.meteorologaaguascalientes.da.DataAccessAdapter;
import org.meteorologaaguascalientes.da.DataAccessException;
import org.meteorologaaguascalientes.vo.ValueObject;
import org.meteorologaaguascalientes.vo.VariableVo;

/**
 *
 * @author tuareg
 */
public abstract class AbstractVariableService<E extends VariableVo> extends AbstractService<E> {

	protected ArrayList<E> data = new ArrayList<E>();
	protected E lastRecord = null;

	
	public E getLastValue(DataAccessAdapter da) throws DataAccessException {
		return getDao(da).getLastValue(da);
	}
	public List<E> getAllValues(DataAccessAdapter dataAccess) throws DataAccessException{
		return getDao(dataAccess).getAllValues(dataAccess);
	}

}
