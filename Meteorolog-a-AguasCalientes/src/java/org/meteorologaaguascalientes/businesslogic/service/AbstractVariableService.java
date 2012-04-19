/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.businesslogic.service;

import java.util.ArrayList;
import java.util.List;
import org.meteorologaaguascalientes.da.DataAccessAdapter;
import org.meteorologaaguascalientes.dao.AbstractVariableDao;

/**
 *
 * @author tuareg
 */
public abstract class AbstractVariableService<E> extends AbstractService<E> {

	protected ArrayList<E> data = new ArrayList<E>();
	protected E lastRecord = null;

	
	protected abstract AbstractVariableDao getDao(DataAccessAdapter da);
		
	

	public E getLastValue(DataAccessAdapter da) {
		getDao(da).
	}

	public List<E> getAllValues(DataAccessAdapter da) {
	}
}
