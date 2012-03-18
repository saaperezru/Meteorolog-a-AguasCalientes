/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.dao;

import java.util.ArrayList;
import java.util.List;
import org.meteorologaaguascalientes.model.Variable;
/**
 *
 * @author tuareg
 */
public abstract class AbstractVariableDao<E> extends Dao<E>{

	protected ArrayList<E>  data = new ArrayList<E>();
	protected E lastRecord = null;

	

	public E getLastValue() {
		return lastRecord;
	}

	public List<E> getAllValues() {
		return data;
	}
	

	
}
