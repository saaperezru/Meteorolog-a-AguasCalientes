/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.dao;

import org.meteorologaaguascalientes.model.Pluviosity;

/**
 *
 * @author tuareg
 */
public class PluviosityDao extends AbstractVariableDao<Pluviosity>{

	@Override
	public boolean createRecord(Pluviosity record) {
		boolean add = data.add(record);
		if (lastRecord == null || (lastRecord.getTime().compareTo(record.getTime()))<=0){
			lastRecord = record;
		}
		return true;
	}

	
	
}
