
package org.meteorologaaguascalientes.businesslogic.service;

public abstract class AbstractService<E> {
	private String visibleName;

	public abstract boolean createRecord(E record);

	public void setVisibleName(String visibleName) {
		this.visibleName = visibleName;
	}

	public String getVisibleName() {
		return visibleName;
	}
}
