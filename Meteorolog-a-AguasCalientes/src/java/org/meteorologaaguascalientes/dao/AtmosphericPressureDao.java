/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.dao;

import org.meteorologaaguascalientes.model.AtmosphericPressure;

/**
 *
 * @author tuareg
 */
public class AtmosphericPressureDao extends AbstractVariableDao<AtmosphericPressure> {

	@Override
	public void createRecord(AtmosphericPressure record) {
		boolean add = data.add(record);
		if (lastRecord == null || (lastRecord.getTime().compareTo(record.getTime()))>0){
			lastRecord = record;
		}
	}
}
