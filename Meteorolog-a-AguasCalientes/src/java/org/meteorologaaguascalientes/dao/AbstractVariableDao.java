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
public abstract class AbstractVariableDao<E> implements Dao<E>{

	private String visibleName;
	protected ArrayList<E>  data = new ArrayList<E>();
	protected E lastRecord;

	public void setVisibleName(String visibleName) {
		this.visibleName = visibleName;
	}

	public String getVisibleName(){
		return visibleName;
	}

	public E getLastValue() {
		return lastRecord;
	}

	public List<E> getAllValues() {
		return data;
	}
	

	
}
