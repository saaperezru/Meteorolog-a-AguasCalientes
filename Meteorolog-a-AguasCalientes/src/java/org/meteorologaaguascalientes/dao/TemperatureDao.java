/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.dao;

import org.meteorologaaguascalientes.model.Temperature;
/**
 *
 * @author tuareg
 */
public class TemperatureDao extends AbstractVariableDao<Temperature> {

	@Override
	public void createRecord(Temperature record) {
		boolean add = data.add(record);
		if (lastRecord == null || (lastRecord.getSample().getTimeStamp().compareTo(record.getSample().getTimeStamp())>0)){
			lastRecord = record;
		}
	}
	
}
