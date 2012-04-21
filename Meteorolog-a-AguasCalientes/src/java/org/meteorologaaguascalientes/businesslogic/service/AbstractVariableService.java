/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.businesslogic.service;

import java.util.List;
import org.meteorologaaguascalientes.da.DataAccessAdapter;
import org.meteorologaaguascalientes.da.DataAccessException;
import org.meteorologaaguascalientes.vo.VariableVo;

/**
 *
 * @author tuareg
 */
public abstract class AbstractVariableService<E extends VariableVo> extends AbstractService<E> {

	
	public E getLastValue(DataAccessAdapter dataAccess) throws DataAccessException {
		return getDao(dataAccess).getLastValue(dataAccess);
	}
	public List<E> getAllValues(DataAccessAdapter dataAccess) throws DataAccessException{
		return getDao(dataAccess).getAllValues(dataAccess);
	}

}
