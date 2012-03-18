/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.dao;

/**
 *
 * @author tuareg
 */
public abstract class Dao<E> {

	private String visibleName;

	public abstract void createRecord(E record);

	public void setVisibleName(String visibleName) {
		this.visibleName = visibleName;
	}

	public String getVisibleName() {
		return visibleName;
	}
}
